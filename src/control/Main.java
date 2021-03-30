package control;

import java.util.Scanner;

import model.*;
import player.Player;

public class Main {
	public static final int NUM_JUGADORES = 2;
	public static final int NUM_ARGS_ADD = 4;
	
	public static int cuentaSkip;
	public static Board board;
	public static Player[] players;
	private static Scanner scanner;
	private static int turno;
	
	// Metodo inicio (LLama a pintar tablero y muestra piezas), actualizar tablero, reset tablero.
	public static void main(String[] args) {
		board = new Board();
		players = new Player[NUM_JUGADORES];
		initJugadores();
		turno = 0; // Empieza el jugador rojo
		scanner = new Scanner (System.in);
		run();
		System.out.println("EL JUEGO HA TERMINADO!");
		System.out.println(calculaPuntuaciones());
	}
	
	public static void run() {
		printGame();
    	while(!isFinished()) {
    		String[] cmd = scanner.nextLine().toLowerCase().split(" ");
    		switch(cmd[0]) {
    		case "a":
    		case "add":
    			if (cmd.length == NUM_ARGS_ADD) {
					int posPieza = Integer.parseInt(cmd[1]);
					int x = Integer.parseInt(cmd[2]);
					int y = Integer.parseInt(cmd[3]);
					if (players[turno % NUM_JUGADORES].canSelectPiece(posPieza)) {
						boolean puede = board.addPieza(players[turno % NUM_JUGADORES].getPiece(posPieza), x, y, 
								(turno == 0 || turno == 1));
						if (!puede) System.out.println("[ERROR]: Esa pieza no puede colocarse en la posición ("
								+ x + ", " + y + "). ");
						else {
							resetSkip();
							players[turno % NUM_JUGADORES].deletePiece(posPieza);
							turno++;
							printGame();
						}
					}
					else
						System.out.println("[ERROR]: La pieza seleccionada no existe. ");
    			}
    			else 
    				System.out.println("[ERROR]: El número de argumentos introducidos no es válido. ");
    			break;
    		case "h":
    		case "help":
    			System.out.println(getHelpMsg());
    			break;
    		case "s":
    		case "skip":
    		case "":
    			cuentaSkip();
    			turno++;
    			printGame();
    			break;
    		default:
    			System.out.println("[ERROR]: No se ha encontrado el comando. Prueba con el comando help. ");
    		}
    	}

	}
	private static String getHelpMsg() {
		return "Los comandos a utilizar: \n"
				+ "[h]elp: muestra este mensaje, \n"
				+ "[s]kip | []: pasa turno \n"
				+ "[a]dd: <pieza> <fila> <columna> \n";
	}

	private static void printGame() {
		System.out.println(board);
		System.out.println(players[turno % 2]);
	}

	private static void initJugadores() {
		char[] colors = {Template.ROJO, Template.AMARILLO, Template.AZUL, Template.VERDE};
		for (int i = 0; i < NUM_JUGADORES; i++) players[i] = new Player(colors[i]);
	}

	private static boolean isFinished() {	
		return cuentaSkip == NUM_JUGADORES;
	}

	public static void resetSkip() {
		cuentaSkip = 0;
	}
	
	public static void cuentaSkip() {
		cuentaSkip++;
	}
	
	public static String calculaPuntuaciones() {
		String puntuaciones = "Las puntuaciones de los jugadores son: ";
		for (int i = 0; i < NUM_JUGADORES; i++)
			puntuaciones += "Jugador " + (players[i].getColor() == Template.ROJO ? "rojo" : "amarillo") 
							+ ": " + players[i].calculaPuntos() + " puntos \n";
		return puntuaciones;
	}
}

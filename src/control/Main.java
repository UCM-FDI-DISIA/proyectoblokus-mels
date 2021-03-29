package control;

import java.util.Scanner;

import model.*;
import player.Player;

public class Main {
	public static int cuentaSkip;
	
	public static Board board;
	public static Player p1, p2;
	private static Scanner scanner;
	
	// Metodo inicio (LLama a pintar tablero y muestra piezas), actualizar tablero, reset tablero.
	public static void main(String[] args) {
		board = new Board();
		p1 = new Player(Template.ROJO);
		p2 = new Player(Template.AMARILLO);
		scanner = new Scanner (System.in);
	
	}
	
	public void run() {
    	// mientras no termine el juego
    		// leer de teclado
    		// ejecutar la orden
    		// actualizar el juego
    		// pintar el juego
		
		
    	//printGame();
    	while(!isFinished()) {
    		
    		String[] cmd = scanner.nextLine().toLowerCase().split(" ");
    		switch(cmd[0]) {
    		case "a":
    		case "add":
    			if (cmd.length == 4) { 
        			int p = Integer.parseInt(cmd[1]);
    				int x = Integer.parseInt(cmd[2]);
    				int y = Integer.parseInt(cmd[3]);
    				
        			if(!board.posicionValida(x, y) || board.somethingInPosition(x, y, p)) {
        				// Comprobamos que no hay nada en la posición en la que se va a añadir
        				// el slayer y que la posición se encuentra dentro del plano
        				System.out.println("ERROR");
        			
            				game.addSlayer(row, col);
            				game.update();
            				if (!game.isFinished())
                    			game.addCycle();
            				printGame();
        				
        			}
    			}
    			else
    				System.out.println(invalidCommandMsg);
    			break;
    		case "h":
    		case "help":
    			System.out.println(helpMsg);
    			break;
    		case "r":
    		case "reset":
    			System.out.println(debugMsg + cmd[0]);
    			game = game.reset();
	    		printGame();
    			break;
    		case "n":
    		case "none":
    		case "":
    			System.out.println(debugMsg + cmd[0]);
    			game.update();
    			if (!game.isFinished())
        			game.addCycle();
        		printGame();
    			break;
    		case "e":
    		case "exit":
    			System.out.println(debugMsg + cmd[0]);
    			System.out.println(exitMsg);
    			System.exit(0); 			
    			break;
    		default:
    			System.out.println(debugMsg + cmd[0]);
    			System.out.println(unknownCommandMsg);
    		}
    		game.checkWinner();
    	}

	
	private boolean isFinished() {	
		return cuentaSkip == 2;
	}

	public static void resetSkip() {
		cuentaSkip = 0;
	}
	
	public static void cuentaSkip() {
		cuentaSkip++;
	}
	
	

}

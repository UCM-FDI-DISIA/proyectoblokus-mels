package model;

import java.awt.Point;

import player.Player;
import view.GamePrinter;

public class Game {
	private int turno;
	private int numJugadores;
	private Board board;
	private Player[] players;
	private static final int DEF_NUMJUGADORES = 2;
	
	public Game(){
		turno = 0;
		board = new Board();
		setNumJugadores(DEF_NUMJUGADORES);
		
	}
	
	public Player getCurrentPlayer() {
		return players[turno];
	}
	public int getTurno() {
		return turno;
	}
	public Board getCurrentBoard() {
		return board;
	}

	public boolean canAddPiece(int x, int y, Piece piezaColoca) {
		return board.canAddPiece(x, y, piezaColoca, players[turno].getPrimerTurno(), players[turno].getEsquina());
	}

	public void colocarPieza(int x, int y, Piece piezaColoca) {
		board.colocarPieza(x, y, piezaColoca);
	}

	public void deletePiece(int selectedPiece) {
		players[turno].deletePiece(selectedPiece);
	}

	public Piece getPiece(int selectedPiece) {
		return players[turno].getPiece(selectedPiece);
	}
	
	public void pasaTurno() {
		turno++;
		if (turno == numJugadores) turno = 0;
	}
	
	public void initJugadores() {
		for (int i = 0; i < numJugadores; i++) {
			players[i] = new Player(Template.getColor(i));
		}
	}

	public void run() {
		new GamePrinter(this);
	}
	
	public void cambiarPrimerTurno() {
		players[turno].setPrimerTurno(false);
	}
	
	public boolean puedeColocarCurrentPlayer() {
		if (players[turno].getPrimerTurno())
			return true;
		if (players[turno].getPuedeColocar()) {
			for(int p = 0; p < Template.NUM_PIEZAS; p++) {
				Piece pieza = new Piece(players[turno].getPiece(p).getPieza(), players[turno].getColor());
				for (int g = 0; g < 4; g++) {
					pieza.giro(); // Giramos la pieza
					Point punto  = pieza.getPrimeraCasilla();
					if(punto != null) {
						System.out.println("La pieza empieza en el punto " + "(" + punto.x + ", " + punto.y + ")");
						pieza.setInicio(punto.x, punto.y);
						System.out.println(pieza.toString());
						// Comprobamos para todas las posiciones del tablero
						for (int i = 0; i < Board.DIMENSION; i++)
							for (int j = 0; j < Board.DIMENSION; j++)
								if (board.canAddPiece(i, j, pieza, false, null)) {
									System.out.println("La pieza " + p + " se puede colocar en (" + i + ", " + j + ")");
									return true;
								}
					}
				}
			}
		}
		return false;
	}

	public void noPuedeColocar() {
		players[turno].setPuedeColocar(false);
	}
	
	public int getNumJugadores() {
		return numJugadores;
	}
	public void setNumJugadores(int num) {
		numJugadores = num;
		players = new Player[numJugadores];
		initJugadores();
	}
	public String getPuntos() {
		String txt = "";
		for (int i = 0; i < numJugadores; i++) {
			txt+="- Jugador "+(i+1)+" ha obtenido "+ players[i].calculaPuntos()+" puntos";
			txt+="\n";
		}
		return txt;
	}
}

package model;

import java.awt.Point;

import javax.swing.JOptionPane;

import player.Player;
import view.GamePrinter;

public class Game {
	private int turno;
	private int numJugadores;
	private Board board;
	private Player[] players;
	private int maquina;
	private GamePrinter printer;
	private static final int DEF_NUMJUGADORES = 2;
	
	public Game(){
		maquina = 0;
		turno = 0;
		board = new Board();
		setNumJugadores(DEF_NUMJUGADORES);
	}
	
	public void setMaquina(int b) {
		maquina = b;
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
		if(getCurrentPlayer().getMaquina() == 2) {
			printer.finishGame(this);
			maquinaDificil();
		}
		else if(getCurrentPlayer().getMaquina() == 1) {
			printer.finishGame(this);
			maquinaFacil();
		}
	}
	
	public void initJugadores() {
		for (int i = 0; i < numJugadores; i++) {
			players[i] = new Player(Template.getColor(i), 0);
			if(maquina == 1 && i == 1)
				players[i] = new Player(Template.getColor(i), 1);
			else if(maquina == 2 && i == 1)
				players[i] = new Player(Template.getColor(i), 2);
		}
	}
	
	public void cambiarPrimerTurno() {
		players[turno].setPrimerTurno(false);
	}
	
	public void run() {
		printer = new GamePrinter(this);
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
	
	public boolean maquinaFacil() {
		if(players[turno].getPrimerTurno()) {
			Point punto  = players[turno].getPiece(0).getPrimeraCasilla();
			players[turno].getPiece(0).setInicio(punto.x, punto.y);
			cambiarPrimerTurno();
			colocarMaquina(0, 19, 0);
			return true;
		}
		if (players[turno].getPuedeColocar()) {
			for(int p = 0; p < Template.NUM_PIEZAS; p++) {
				for (int g = 0; g < 4; g++) {
					players[turno].getPiece(p).giro(); // Giramos la pieza
					Point punto  = players[turno].getPiece(p).getPrimeraCasilla();
					if(punto != null) {
						System.out.println("La pieza empieza en el punto " + "(" + punto.x + ", " + punto.y + ")");
						players[turno].getPiece(p).setInicio(punto.x, punto.y);
						// Comprobamos para todas las posiciones del tablero
						for (int i = 0; i < Board.DIMENSION; i++)
							for (int j = 0; j < Board.DIMENSION; j++)
								if (board.canAddPiece(i, j, players[turno].getPiece(p), false, null)) {
									colocarMaquina(i, j, p);
									return true;
								}
					}
				}
			}
		}
		return false;
	}
	
	public boolean maquinaDificil() {
		if(players[turno].getPrimerTurno()) {
			players[turno].getPiece(19).giro();
			Point punto  = players[turno].getPiece(19).getPrimeraCasilla();
			players[turno].getPiece(19).setInicio(punto.x, punto.y);
			cambiarPrimerTurno();
			colocarMaquina(0, 18, 19);
			return true;
		}
		if (players[turno].getPuedeColocar()) {
			for(int p = Template.NUM_PIEZAS - 1; p > 0; p--) {
				for (int g = 0; g < 4; g++) {
					players[turno].getPiece(p).giro(); // Giramos la pieza
					Point punto  = players[turno].getPiece(p).getPrimeraCasilla();
					if(punto != null) {
						System.out.println("La pieza empieza en el punto " + "(" + punto.x + ", " + punto.y + ")");
						players[turno].getPiece(p).setInicio(punto.x, punto.y);
						// Comprobamos para todas las posiciones del tablero
						for (int i = 0; i < Board.DIMENSION; i++)
							for (int j = 0; j < Board.DIMENSION; j++)
								if (board.canAddPiece(i, j, players[turno].getPiece(p), false, null)) {
									colocarMaquina(i, j, p);
									return true;
								}
					}
				}
			}
		}
		return false;
	}
	
	private void colocarMaquina(int x, int y, int pos) {
		colocarPieza(x, y, players[turno].getPiece(pos));
		getCurrentPlayer().setUltima(players[turno].getPiece(pos));
		deletePiece(pos);
		pasaTurno();
	}


	
	
}

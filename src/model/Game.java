package model;

import player.Player;
import view.GamePrinter;

public class Game {
	private int turno;
	private int numJugadores;
	private Board board;
	private Player[] players;
	private GamePrinter gamePrinter;
	
	public Game(int numJugadores){
		turno = 0;
		board = new Board();
		this.numJugadores = numJugadores;
		players = new Player[numJugadores];
		initJugadores();
	}
	
	public Player getCurrentPlayer() {
		return players[turno];
	}
	
	public Board getCurrentBoard() {
		return board;
	}

	public boolean canAddPiece(int x, int y, Piece piezaColoca, boolean b) {
		return board.canAddPiece(x, y, piezaColoca, b);
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
		gamePrinter = new GamePrinter(this);
	}
	
}

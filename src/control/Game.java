package control;

import java.awt.Point;

import estrategias.Dificil;
import estrategias.Facil;
import model.BlokusObserver;
import model.Board;
import model.Piece;
import model.Template;
import player.Maquina;
import player.Player;
import view.GamePrinter;

public class Game {
	private int turno;
	private int numJugadores;
	private Board board;
	private Player[] players;
	private int maquina;
	private BlokusObserver o;
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
	
	public Player getJugadorActual() {
		return players[turno];
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Board getTableroActual() {
		return board;
	}

	public boolean sePuedeAnyadir(int x, int y, Piece piezaColoca) {
		return board.sePuedeAnyadirPieza(x, y, piezaColoca, players[turno].getPrimerTurno(), players[turno].getEsquina());
	}

	public void colocarPieza(int x, int y, Piece piezaColoca) {
		board.colocarPieza(x, y, piezaColoca);
		o.cambioTablero();
	}

	public void eliminarPieza(int selectedPiece) {
		players[turno].eliminarPieza(selectedPiece);
		o.cambioJugador();
	}

	public Piece getPiece(int selectedPiece) {
		return players[turno].getPiece(selectedPiece);
	}
	
	public void addObserver(BlokusObserver o){
		this.o = o;
	}
	
	public void pasaTurno() {
		turno++;
		if (turno == numJugadores) turno = 0;
		if(getJugadorActual().esMaquina()) {
			getJugadorActual().anyadirPieza();
		}
		o.cambioJugador();
	}
	
	public void girarPieza(int p) {
		players[turno].girar(p);
		o.cambioJugador();
	}
	
	public void cambiarPrimerTurno() {
		players[turno].setPrimerTurno(false);
	}
	
	public void run() {
		o = new GamePrinter(this);
	}
	
	public boolean puedeColocarJugadorActual() {
		if (players[turno].getPrimerTurno())
			return true;
		if (players[turno].getPuedeColocar()) {
			for(int p = 0; p < Template.NUM_PIEZAS; p++) {
				Piece pieza = new Piece(players[turno].getPiece(p).getPieza(), players[turno].getColor());
				for (int g = 0; g < 4; g++) {
					pieza.girar(); // Giramos la pieza
					Point punto  = pieza.getPrimeraCasilla();
					if(punto != null) {
						pieza.setInicio(punto.x, punto.y);
						// Comprobamos para todas las posiciones del tablero
						for (int i = 0; i < Board.DIMENSION; i++)
							for (int j = 0; j < Board.DIMENSION; j++)
								if (board.sePuedeAnyadirPieza(i, j, pieza, false, null))
									return true;
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
		inicializarJugadores();
	}
	
	public String getPuntos() {
		String txt = "";
		for (int i = 0; i < numJugadores; i++) {
			txt+="- Jugador "+(i+1)+" ha obtenido "+ players[i].calculaPuntos()+" puntos";
			txt+="\n";
		}
		return txt;
	}
	
	public void colocarMaquina(int x, int y, int pos) {
		colocarPieza(x, y, players[turno].getPiece(pos));
		getJugadorActual().setUltima(players[turno].getPiece(pos));
		eliminarPieza(pos);
		pasaTurno();
		o.finJuego();
	}

	public boolean estaEliminado() {
		return !players[turno].getPuedeColocar();
	}
	
	private void inicializarJugadores() {
		for (int i = 0; i < numJugadores; i++) {
			players[i] = new Player(Template.getColor(i));
			if(maquina == 1 && i == 1)
				players[i] = new Maquina(Template.getColor(i), new Facil(this));
			else if(maquina == 2 && i == 1)
				players[i] = new Maquina(Template.getColor(i), new Dificil(this));
		}
	}
}

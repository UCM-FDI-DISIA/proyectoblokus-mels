package model.estrategias;

import java.awt.Point;

import model.*;

public class Facil implements Strategy{

	private Game game;
	
	public Facil(Game game) {
		this.game = game;
	}

	@Override
	public boolean anyadirPieza() {	
		if(game.getJugadorActual().getPrimerTurno()) {
			game.getJugadorActual().getPiece(0).girar();
			Point punto  = game.getJugadorActual().getPiece(0).getPrimeraCasilla();
			game.getJugadorActual().getPiece(0).setInicio(punto.x, punto.y);
			game.cambiarPrimerTurno();
			game.colocarMaquina(0, 19, 0);
			return true;
		}
		if (game.getJugadorActual().getPuedeColocar()) {
			for(int p = 0; p < Template.NUM_PIEZAS; p++) {
				for (int g = 0; g < 4; g++) {
					game.getJugadorActual().getPiece(p).girar(); // Giramos la pieza
					Point punto  = game.getJugadorActual().getPiece(p).getPrimeraCasilla();
					if(punto != null) {
						game.getJugadorActual().getPiece(p).setInicio(punto.x, punto.y);
						// Comprobamos para todas las posiciones del tablero
						for (int i = 0; i < Board.DIMENSION; i++)
							for (int j = 0; j < Board.DIMENSION; j++) 
								if (game.getTableroActual().sePuedeAnyadirPieza(i, j, game.getJugadorActual().getPiece(p), false, null)) {
									game.colocarMaquina(i, j, p);
									return true;
								}
						game.getJugadorActual().getPiece(p).eliminarInicio();
					}
				}
			}
		}
		return false;
	}
}

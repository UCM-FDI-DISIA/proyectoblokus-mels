package estrategias;

import java.awt.Point;

import control.Game;
import model.*;

public class Facil implements Strategy{

	private Game game;
	
	public Facil(Game game) {
		this.game = game;
	}

	@Override
	public boolean addPiece() {	
		if(game.getCurrentPlayer().getPrimerTurno()) {
			game.getCurrentPlayer().getPiece(0).giro();
			Point punto  = game.getCurrentPlayer().getPiece(0).getPrimeraCasilla();
			game.getCurrentPlayer().getPiece(0).setInicio(punto.x, punto.y);
			game.cambiarPrimerTurno();
			game.colocarMaquina(0, 19, 0);
			return true;
		}
		if (game.getCurrentPlayer().getPuedeColocar()) {
			for(int p = 0; p < Template.NUM_PIEZAS; p++) {
				for (int g = 0; g < 4; g++) {
					game.getCurrentPlayer().getPiece(p).giro(); // Giramos la pieza
					Point punto  = game.getCurrentPlayer().getPiece(p).getPrimeraCasilla();
					if(punto != null) {
						game.getCurrentPlayer().getPiece(p).setInicio(punto.x, punto.y);
						// Comprobamos para todas las posiciones del tablero
						for (int i = 0; i < Board.DIMENSION; i++)
							for (int j = 0; j < Board.DIMENSION; j++)
								if (game.getCurrentBoard().canAddPiece(i, j, game.getCurrentPlayer().getPiece(p), false, null)) {
									game.colocarMaquina(i, j, p);
									return true;
								}
					}
				}
			}
		}
		return false;
	}
}

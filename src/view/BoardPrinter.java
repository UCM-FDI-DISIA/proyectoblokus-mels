package view;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.Board;

public class BoardPrinter {
	
	public BufferedImage dibujarTablero(Board b) {
		return b.dibujarTablero();
	}
	
	public Point getCasilla(Board board, int coordX, int coordY) {
		return board.getCasilla(coordX, coordY);
	}
}

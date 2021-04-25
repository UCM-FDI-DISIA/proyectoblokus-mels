package view;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.Board;

public class BoardPrinter {
	
	public BufferedImage printBoard(Board b) {
		return b.drawBoard();
	}
	
	public Point getCasilla(Board board, int coordX, int coordY) {
		return board.getCasilla(coordX, coordY);
	}
}

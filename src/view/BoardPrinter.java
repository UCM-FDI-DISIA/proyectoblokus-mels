package view;

import java.awt.image.BufferedImage;

import model.Board;

public class BoardPrinter {
	
	public BufferedImage printBoard(Board b) {
		return b.drawBoard();
	}
}

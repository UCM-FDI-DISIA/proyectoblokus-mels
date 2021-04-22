package view;

import java.awt.image.BufferedImage;

import model.Piece;

public class PiecePrinter {
	public BufferedImage printPiece(Piece p) {
		return p.drawPiece(p.getColor());
	}
}

package view;

import java.awt.image.BufferedImage;

import model.Piece;

public class PiecePrinter {
	public BufferedImage dibujarPieza(Piece p) {
		return p.dibujarPieza(p.getColor());
	}
}

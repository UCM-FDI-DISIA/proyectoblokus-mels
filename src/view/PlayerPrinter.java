package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.player.Player;

public class PlayerPrinter {
	
	public JPanel dibujarPiezasJugador(Player p) {
		JPanel playerPanel = new JPanel(new GridLayout(0, 5));
		playerPanel.setBackground(Color.WHITE);
		PiecePrinter pieceP = new PiecePrinter();
		for (int i = 0; i < p.numPiezas(); i++) {
			ImageIcon boardImagePiece = new ImageIcon(pieceP.dibujarPieza(p.getPiece(i)));
			JLabel labelPiece = new JLabel(boardImagePiece);
			playerPanel.add(labelPiece);
		}
		return playerPanel;
	}
	public int getPiezaVentana(Player p, int coordX, int coordY) {
		return p.getPiezaVentana(coordX, coordY);
	}
}

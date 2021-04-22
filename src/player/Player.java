package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.Piece;
import model.Template;

public class Player {
	private ArrayList<Piece> piezas;
	private Color color;
	private Piece ultima;
	
	// Parte de piezas:
	public Player(Color color) {
		this.color = color;
		piezas = new ArrayList<Piece>();
		initPiezas();
	}
	
	public void initPiezas() {
		for (int i = 0; i < Template.NUM_PIEZAS; i++)
			piezas.add(new Piece(Template.plantilla[i], color));
	}
	
	public int calculaPuntos() {
		int numPuntos = 0;
		for(Piece p: piezas) numPuntos -= p.calculaPuntos();
		if (todasColocadas(numPuntos) && Template.esCuadrado(ultima)) numPuntos = Template.PUNTOS_CUADRADO;
		else if (todasColocadas(numPuntos)) numPuntos = Template.PUNTOS_GANADOR;
		return numPuntos;
	}
	
	public boolean todasColocadas(int numPuntos) {
		return numPuntos == 0;
	}
	
	public boolean canSelectPiece(int posPieza) {
		return posPieza >= 0 && posPieza < piezas.size();
	}
	
	public Piece getPiece(int pos) {
		return piezas.get(pos);
	}
	
	public Color getColor() {
		return color;
	}
	
	public void deletePiece(int pos) {
		piezas.remove(pos);
	}
	public int numPiezas() {
		return piezas.size();
	}
}

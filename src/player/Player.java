package player;

import java.util.ArrayList;
import model.Piece;
import model.Template;

public class Player {
	private ArrayList<Piece> piezas;
	private char color;
	private Piece ultima;
	
	// Parte de piezas:
	public Player(char color) {
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
	
	/*public String toString() {
		String p = "Jugador " + (color == Template.ROJO ? "rojo" : "amarillo") + ": \n\n";
		p += "Piezas: \n";
		for (int i = 0; i < piezas.size(); ++i) p += i + ")" + piezas.get(i).toString() + " ";
		return p;
	}*/
	
	public boolean canSelectPiece(int posPieza) {
		return posPieza >= 0 && posPieza < piezas.size();
	}
	
	public Piece getPiece(int pos) {
		return piezas.get(pos);
	}
	
	public char getColor() {
		return color;
	}
	
	public void deletePiece(int pos) {
		piezas.remove(pos);
	}
}

package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.Piece;
import model.Template;

public class Player {
	private ArrayList<Piece> piezas;
	private Color color;
	private Piece ultima;
	private boolean primerTurno;
	private Point esquina;
	private boolean puedeColocar;
	
	// Parte de piezas:
	public Player(Color color) {
		this.color = color;
		piezas = new ArrayList<Piece>();
		primerTurno = true;
		setEsquina();
		initPiezas();
		puedeColocar = true;
	}
	
	public boolean getPrimerTurno() {
		return primerTurno;
	}
	
	public void setPrimerTurno(boolean b) {
		primerTurno = b;
	}
	
	public Point getEsquina(){
		return esquina;
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
		piezas.get(pos).delete();
	}
	public int numPiezas() {
		return piezas.size();
	}
	
	public int getPiezaVentana(int coordX, int coordY) {
		int piece = -1;
		int tamPieza = Piece.getRESOLUCION();
		for (int i = 0; i < 5 * tamPieza; i += tamPieza) {
			int ventanaX = 608 + i;
			for (int j = 0; j < 5 * tamPieza && (j/tamPieza) * 5 + i/tamPieza <= 20; j += tamPieza) {
				int ventanaY = 30 + j;
				if (coordX >= ventanaX && coordY >= ventanaY && 
					coordX <= ventanaX + tamPieza && coordY <= ventanaY + tamPieza) {
					Piece piezaSeleccionada = piezas.get((j/tamPieza) * 5 + i/tamPieza);
					Point casillaSeleccionada = 
							piezaSeleccionada.getCasillaPieza(coordX - ventanaX, coordY - ventanaY);
					if (casillaSeleccionada != null && piezaSeleccionada.esPieza(casillaSeleccionada.x, casillaSeleccionada.y)){
						piece = (j/tamPieza) * 5 + i/tamPieza;
						piezaSeleccionada.setInicio(casillaSeleccionada.x, casillaSeleccionada.y);
					}
					break;
				}
			}
		}
		return piece;
	}
	
	public void setEsquina() {
		if(color.equals(Color.GREEN)) 
			esquina = new Point(0 ,0);
		else if (color.equals(Color.BLUE))
			esquina = new Point(0, 19);
		else if(color.equals(Color.YELLOW))
			esquina = new Point(19, 0);
		else
			esquina = new Point(19, 19);
	}
	
	public void girar(int p) {
		piezas.get(p).giro();
	}
	
	public void setPuedeColocar(boolean b) {
		puedeColocar = b;
	}
	
	public boolean getPuedeColocar() {
		return puedeColocar;
	}
	
}

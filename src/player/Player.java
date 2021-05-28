package player;

import java.awt.Color;
import java.awt.Point;
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
	
	//Parte de piezas:
	//Maquina: 0->jugador normal, 1->facil, 2->dificil
	public Player(Color color) {
		this.color = color;
		piezas = new ArrayList<Piece>();
		primerTurno = true;
		setEsquina();
		inicializarPiezas();
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
	
	public int calculaPuntos() {
		int numPuntos = 0;
		for(Piece p: piezas) 
			numPuntos -= p.calculaPuntos();
		ultima.eliminarInicio();
		if (todasColocadas(numPuntos) && Template.esCuadrado(ultima)) 
			numPuntos = Template.PUNTOS_CUADRADO;
		else if (todasColocadas(numPuntos)) 
			numPuntos = Template.PUNTOS_GANADOR;
		return numPuntos;
	}
	
	public void setUltima(Piece p) {
		ultima = new Piece(p.getPieza(), p.getColor());
	}
	
	public boolean todasColocadas(int numPuntos) {
		return numPuntos == 0;
	}
	
	public boolean sePuedeSeleccionarPieza(int posPieza) {
		return posPieza >= 0 && posPieza < piezas.size();
	}
	
	public Piece getPiece(int pos) {
		return piezas.get(pos);
	}
	
	public Color getColor() {
		return color;
	}
	
	public void eliminarPieza(int pos) {
		piezas.get(pos).eliminar();
	}
	public int numPiezas() {
		return piezas.size();
	}
	
	public int getPiezaVentana(int coordX, int coordY) {
		int piece = -1;
		int tamPieza = Piece.getRESOLUCION();
		for (int i = 0; i < 5 * tamPieza; i += tamPieza) {
			int ventanaX = 507 + i;
			for (int j = 0; j < 5 * tamPieza && (j/tamPieza) * 5 + i/tamPieza <= 20; j += tamPieza) {
				int ventanaY = 30 + j;
				if (dentroPiezas(ventanaX, ventanaY, coordX, coordY, tamPieza)) {
					Piece piezaSeleccionada = piezas.get((j/tamPieza) * 5 + i/tamPieza);
					Point casillaSeleccionada = 
							piezaSeleccionada.getCasillaPieza(coordX - ventanaX, coordY - ventanaY);
					if (tocandoPieza(casillaSeleccionada, piezaSeleccionada)){
						piece = (j/tamPieza) * 5 + i/tamPieza;
						piezaSeleccionada.setInicio(casillaSeleccionada.x, casillaSeleccionada.y);
					}
					break;
				}
			}
		}
		return piece;
	}
	
	public void girar(int p) {
		piezas.get(p).girar();
	}
	
	public void setPuedeColocar(boolean b) {
		puedeColocar = b;
	}
	
	public boolean getPuedeColocar() {
		return puedeColocar;
	}
	
	public boolean esMaquina() {
		return false;
	}
	
	private void inicializarPiezas() {
		for (int i = 0; i < Template.NUM_PIEZAS; i++)
			piezas.add(new Piece(Template.plantilla[i], color));
	}
	
	private void setEsquina() {
		if(color.equals(Color.GREEN)) 
			esquina = new Point(0 ,0);
		else if (color.equals(Color.BLUE))
			esquina = new Point(0, 19);
		else if(color.equals(Color.YELLOW))
			esquina = new Point(19, 0);
		else
			esquina = new Point(19, 19);
	}
	
	private boolean dentroPiezas(int ventanaX, int ventanaY, int coordX, int coordY, int tamPieza) {
		return coordX >= ventanaX && coordY >= ventanaY && 
					coordX <= ventanaX + tamPieza && coordY <= ventanaY + tamPieza;
	}
	
	private boolean tocandoPieza(Point casillaSeleccionada, Piece piezaSeleccionada) {
		return casillaSeleccionada != null && piezaSeleccionada.esPieza(casillaSeleccionada.x, casillaSeleccionada.y);
	}
	
	public void anyadirPieza() {
		
	}
}

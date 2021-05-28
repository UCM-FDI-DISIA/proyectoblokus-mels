package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Board {
	public static final int DIMENSION = 20;
	private static final int RESOLUCION= 500;
	private static final Color COLOR_FONDO = Color.LIGHT_GRAY;
	private static final Color COLOR_LINEA =Color.GRAY;
	
	private Color[][] aux;
	
	public Board() { // Inicializa el tablero como vacío
		aux = new Color[DIMENSION][DIMENSION];
		inicializarTableroAux();
	}
	
	public void inicializarTableroAux() {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				aux[i][j]= COLOR_FONDO;
			}
		}
	}
	
	public BufferedImage dibujarTablero() {
		BufferedImage bi = new BufferedImage(RESOLUCION, RESOLUCION, BufferedImage.TYPE_INT_RGB);
		int celda = RESOLUCION/DIMENSION;
		Graphics gr = bi.getGraphics();
		
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				gr.setColor(aux[j][i]);
				gr.fillRect(i * celda, j * celda, celda, celda);
		        gr.setColor(COLOR_LINEA);
		        gr.drawRect(i * celda, j * celda, celda, celda);
			}
		}
		return bi;
	}
	
	public boolean sePuedeAnyadirPieza(int x, int y, Piece pieza, boolean primera, Point esquina) { // Comprobaciones para la parte de la pieza
		boolean canAdd = false;
		for (int i = 0; i < Template.TAM; i++) {
			int a = x + i - pieza.getXInicio();
			for (int j = 0; j < Template.TAM; j++) {
				int b = y + j - pieza.getYInicio();
				if (posicionOcupada(i, j, a, b, pieza)) 
					return false;
				if (posicionValida(primera,i, j, a, b, pieza))
					canAdd = true;
				if (posicionNoValida(i, j, a, b, pieza))
					return false;
			}
		}
		if(primera && principio(x, y, pieza, esquina))
			canAdd = true;
		return canAdd;
	}
	
	public void colocarPieza(int x, int y, Piece pieza) {
		for (int i = 0; i < Template.TAM; i++) {
			int a = x + i - pieza.getXInicio();
			for (int j = 0; j < Template.TAM; j++) {
				int b = y + j - pieza.getYInicio();
				if (pieza.esPieza(i, j) || pieza.esInicio(i, j)) 
					anyadirColor(a, b, pieza.getColor());
			}
		}
	}
	
	public Point getCasilla(int coordX, int coordY) {
		int tamCelda = RESOLUCION/DIMENSION;
		Point p = null;
		for (int i = 0; i < RESOLUCION; i = tamCelda + i) {
			int ventanaX = i;
			for (int j = 0; j < RESOLUCION; j = tamCelda + j) {
				int ventanaY = 130 + j;
				if (dentroTablero(ventanaX, ventanaY, coordX, coordY, tamCelda)) {
					p = new Point(j / tamCelda, i / tamCelda);
					break;
				}
			}
		}
		return p;
	}
	
	private boolean isEmpty(int i, int j) {
		return aux[i][j].equals(COLOR_FONDO);
	}
	
	private boolean coordEnPlano(int x, int y) {
		return x >= 0 && x < DIMENSION && y >= 0 && y < DIMENSION;
	}
	
	private boolean mismoColor(int i, int j, Color color) {
		return aux[i][j].equals(color);
	}

	private void anyadirColor(int i, int j, Color color) {
		aux[i][j] = color;
	}
	
	private boolean principio(int x, int y, Piece pieza, Point esquina) {
		if(x == esquina.x && y == esquina.y) 
			return true;
		for (int i = 0; i < Template.TAM; i++) {
			int a = x + i - pieza.getXInicio();
			for (int j = 0; j < Template.TAM; j++) {
				int b = y + j - pieza.getYInicio();
				if ((pieza.esPieza(i, j) || pieza.esInicio(i, j)) && a == esquina.x && b == esquina.y)
					return true;
			}
		}
		return false;
	}
	
	private boolean dentroTablero(int ventanaX, int ventanaY, int coordX, int coordY, int tamCelda) {
		return coordX >= ventanaX && coordY >= ventanaY && 
					coordX <= ventanaX + tamCelda && coordY <= ventanaY + tamCelda;
	}
	
	private boolean posicionOcupada(int i, int j, int a, int b, Piece pieza) {
		return (pieza.esPieza(i, j) || pieza.esInicio(i, j)) && (!coordEnPlano(a, b) || !isEmpty(a, b));
	}
	
	private boolean posicionValida(boolean primera,int i, int j, int a, int b, Piece pieza) {
		return !primera && pieza.esEsquina(i, j) && coordEnPlano(a, b) && mismoColor(a, b, pieza.getColor());
	}
	
	private boolean posicionNoValida(int i, int j, int a, int b, Piece pieza) {
		return pieza.esLado(i, j) && coordEnPlano(a, b) && mismoColor(a, b, pieza.getColor());
	}
}

package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Board {
	private static final int DIMENSION = 20;
	private static final int RESOLUCION= 500;
	private static final Color COLOR_FONDO = Color.LIGHT_GRAY;
	private static final Color COLOR_LINEA =Color.GRAY;
	
	private int[][] tablero; // El array bidimensional que lleva todo el contenido del tablero
	
	public Board() { // Inicializa el tablero como vacío
		tablero = new int[DIMENSION][DIMENSION];
	}
	public Color getColor(int posicion) {
		 switch (posicion)
	      {
	         default: return COLOR_FONDO;
	      }
	}
	public BufferedImage drawBoard() {
		BufferedImage bi = new BufferedImage(RESOLUCION, RESOLUCION, BufferedImage.TYPE_INT_RGB);
		int celda = RESOLUCION/DIMENSION;
		Graphics gr = bi.getGraphics();
		
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				gr.setColor(getColor(tablero[i][j]));
				gr.fillRect(i * celda, j * celda, celda, celda);
		        gr.setColor(COLOR_LINEA);
		        gr.drawRect(i * celda, j * celda, celda, celda);
			}
		}
		return bi;
	}

	
	public void addColor(int i, int j, char color) {
		tablero[i][j] = color;
	}
	
	public boolean coordInPlane(int x, int y) {
		return x >= 0 && x < DIMENSION && y >= 0 && y < DIMENSION;
	}
	
	public boolean isEmpty(int i, int j) {
		return tablero[i][j] == ' ';
	}
	
	public boolean canAddPiece(int x, int y, Piece pieza, boolean primera) { // Comprobaciones para la parte de la pieza
		boolean hayEsquinas = primera;
		for (int i = 0; i < Template.TAM; i++) {
			int a = x + i - pieza.getXInicio() - 1;
			for (int j = 0; j < Template.TAM; j++) {
				int b = y + j - pieza.getYInicio() - 1;
				if (pieza.esPieza(i, j) && (!coordInPlane(a, b) || !isEmpty(a, b))) return false;
				if (!primera && pieza.esEsquina(i, j) && coordInPlane(a, b) && sameColor(a, b, pieza.getColor()))
					hayEsquinas = true;
				if (pieza.esLado(i, j) && coordInPlane(a, b) && sameColor(a, b, pieza.getColor()))
					return false;
			}
		}
		return hayEsquinas;
	}
	
	public boolean sameColor(int i, int j, char color) {
		return tablero[i][j] == color;
	}
	
	public void colocarPieza(int x, int y, Piece pieza) {
		for (int i = 0; i < Template.TAM; i++) {
			int a = x + i - pieza.getXInicio() - 1;
			for (int j = 0; j < Template.TAM; j++) {
				int b = y + j - pieza.getYInicio() - 1;
				if (pieza.esPieza(i, j) || pieza.esInicio(i, j)) addColor(a, b, pieza.getColor());
			}
		}
	}
	
	public boolean addPieza(Piece pieza, int x, int y, boolean primera) {
		if (canAddPiece(x, y, pieza, primera)) {
			colocarPieza(x, y, pieza);
			return true;
		}
		else return false;
	}
}

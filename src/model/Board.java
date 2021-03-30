package model;

public class Board {
	private static final int DIMENSION = 20;
	private static final char VACIO = ' ';
	private static final String CASILLA_ARRIBA = "-----";
	
	private char[][] tablero; // El array bidimensional que lleva todo el contenido del tablero
	
	public Board() { // Inicializa el tablero como vacío
		tablero = new char[DIMENSION][DIMENSION];
		for (int i = 0; i < DIMENSION; i++)
			for (int j = 0; j < DIMENSION; j++)
				tablero[i][j] = VACIO;
	}
	
	public String toString() {
		String tab = generaNumeracion() + "\n";
		tab += generaLineas() + "\n"; // Generamos la linea inicial
		for (int i = 0; i < DIMENSION; i++) {
			tab += "|";
			for (int j = 0; j < DIMENSION; j++)
				tab += "  " + tablero[i][j] + "  |";
			tab += " " + (i + 1) + "\n";
			tab += generaLineas() + "\n";
		}
		return tab;
	}
	
	public String generaLineas() { // Genera las casillas 
		String lineas = " ";
		for (int i = 0; i < DIMENSION; i++) 
			lineas += CASILLA_ARRIBA + " ";
		return lineas;
	}
	
	public String generaNumeracion() {
		String numeros = "   ";
		for (int i = 1; i < 9; i++)
			numeros += i + "     ";
		numeros += "9    ";
		for (int i = 10; i <= DIMENSION; i++)
			numeros += i + "    ";
		return numeros;
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

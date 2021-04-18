package model;

public class Piece {	
	private int[][] pieza;
	private char color;
	
	public Piece(int[][] pieza, char color) {
		this.pieza = pieza;
		this.color = color;
	}
	
	public char getColor() {
		return color;
	}
	
	public int[][] getPieza() {
		return pieza;
	}
	
	public int calculaPuntos() {
		int num = 0;
		for (int i = 0; i < Template.TAM; ++i)
			for (int j = 0; j < Template.TAM; ++j)
				if (pieza[i][j] == 3 || pieza[i][j] == 4) ++num;
		return num;		
	}
	
	public String toString() {
		String p = "";
		for (int i = 0; i < Template.TAM; ++i) {
			for (int j = 0; j < Template.TAM; ++j) {
				if (pieza[i][j] == 3 || pieza[i][j] == 4) p += color;
				else p += ' ';
			}
			p += "\n";
		}
		return p;
	}
	
	public boolean esPieza(int i, int j) {
		return pieza[i][j] == 3;
	}
	
	public boolean esEsquina(int i, int j) {
		return pieza[i][j] == 1;
	}
	
	public boolean esLado(int i, int j) {
		return pieza[i][j] == 2;
	}
	
	public boolean esInicio(int i, int j) {
		return pieza[i][j] == 4;
	}
	
	public int getXInicio() {
		for (int i = 0; i < Template.TAM; i++)
			for (int j = 0; j < Template.TAM; j++)
				if (pieza[i][j] == 4) return i;
		return 0;
	}
	
	public int getYInicio() {
		for (int i = 0; i < Template.TAM; i++)
			for (int j = 0; j < Template.TAM; j++)
				if (pieza[i][j] == 4) return j;
		return 0;
	}
}
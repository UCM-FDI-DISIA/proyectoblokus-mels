package model;

public class Piece {	
	private char[][] pieza;
	private char color;
	
	public Piece(char[][] pieza, char color) {
		this.pieza = pieza;
		this.color = color;
	}
	
	public char getColor() {
		return color;
	}
	public char[][] getPieza() {
		return pieza;
	}
	public int calculaPuntos() {
		int num = 0;
		for (int i = 0; i < Template.TAM; ++i)
			for (int j = 0; j < Template.TAM; ++j)
				if (pieza[i][j] == 'P' || pieza[i][j] == 'I') ++num;
		return num;		
	}
	public String toString() {
		String p = "";
		for (int i = 0; i < Template.TAM; ++i) {
			for (int j = 0; j < Template.TAM; ++j) {
				if (pieza[i][j] == 'P' || pieza[i][j] == 'I') p += color;
				else p += ' ';
			}
			p += "\n";
		}
		return p;
	}
}
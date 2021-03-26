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
}
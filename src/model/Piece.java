package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Piece {	
	private int[][] pieza;
	private Color color;
	private static final int RESOLUCION=100;
	
	public Piece(int[][] pieza, Color color) {
		this.pieza = pieza;
		this.color = color;
	}
	
	public Color getColor() {
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
	
	public BufferedImage drawPiece() {
		BufferedImage bi = new BufferedImage(RESOLUCION, RESOLUCION, BufferedImage.TYPE_INT_RGB);
		int celda = RESOLUCION/Template.TAM;
		Graphics gr = bi.getGraphics();
		gr.setColor(Color.WHITE);
	    gr.fillRect(0, 0, RESOLUCION, RESOLUCION);
		for (int i = 0; i < Template.TAM; i++) {
			for (int j = 0; j < Template.TAM; j++) {
				if(pieza[i][j] == Template.PIEZA || pieza[i][j] == Template.INICIO) {
					gr.setColor(color.CYAN);
					gr.fillRect(i * celda, j * celda, celda, celda);
			        gr.setColor(color.BLACK);
			        gr.drawRect(i * celda, j * celda, celda, celda);
				}
			}
		}
		return bi;
		
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
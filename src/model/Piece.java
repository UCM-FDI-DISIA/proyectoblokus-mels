package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Piece {	
	private int[][] pieza;
	private Color color;
	private static final int RESOLUCION = 140;
	
	public Piece(int[][] pieza, Color color) {
		this.pieza = new int[Template.TAM][Template.TAM];
		setPieza(pieza);
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
	
	public BufferedImage drawPiece(Color c) {
		BufferedImage bi = new BufferedImage(RESOLUCION, RESOLUCION, BufferedImage.TYPE_INT_RGB);
		int celda = RESOLUCION/Template.TAM;
		Graphics gr = bi.getGraphics();
		gr.setColor(Color.WHITE);
	    gr.fillRect(0, 0, RESOLUCION, RESOLUCION);
		for (int i = 0; i < Template.TAM; i++) {
			for (int j = 0; j < Template.TAM; j++) {
				if(pieza[i][j] == Template.PIEZA || pieza[i][j] == Template.INICIO) {
					gr.setColor(c);
					gr.fillRect(j * celda, i * celda, celda, celda);
			        gr.setColor(color.BLACK);
			        gr.drawRect(j * celda, i * celda, celda, celda);
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
	
	public static int getRESOLUCION() {
		return RESOLUCION;
	}

	public Point getCasillaPieza(int coordX, int coordY) {
		int tamCelda = RESOLUCION/Template.TAM;
		Point p = null;
		for (int i = 0; i < RESOLUCION; i = tamCelda + i) {
			for (int j = 0; j < RESOLUCION; j = tamCelda + j) {
				if (coordX >= i && coordY >= j && 
					coordX <= i + tamCelda && coordY <= j + tamCelda) {
					p = new Point(j / tamCelda, i / tamCelda);
					break;
				}
			}
		}
		return p;
	}
	
	public void setInicio(int x, int y) {
		pieza[x][y] = 4;
	}
	
	public void setPieza(int[][] p) {
		for (int i = 0; i < Template.TAM; i++)
			for (int j = 0; j < Template.TAM; j++)
				pieza[i][j] = p[i][j];
	}
	
	public void delete() {
		for (int i = 0; i < Template.TAM; i++)
			for (int j = 0; j < Template.TAM; j++)
				pieza[i][j] = 0;
	}
	
}
package model;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import view.TransparentTransformation;

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
		Graphics2D gr = (Graphics2D) bi.getGraphics();
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

		TransparentTransformation transparent = new TransparentTransformation(bi);
		bi = transparent.makeColorTransparent(Color.WHITE);

		gr.setColor(Color.WHITE);
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
	
	public void deleteInicio() {
		for (int i = 0; i < Template.TAM; i++)
			for (int j = 0; j < Template.TAM; j++)
				if (pieza[i][j] == 4) pieza[i][j] = 3;
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
	
	
	public void giro() {
		int [][] aux = new int[Template.TAM][Template.TAM];
		for (int i = 0; i < Template.TAM; i++) 
			for (int j = 0; j < Template.TAM; j++) 
				aux[j][Template.TAM - i - 1] = pieza[i][j];
		pieza = aux;
	}
	
	public Point getCoordsInicio() {
		int tamCelda = RESOLUCION/Template.TAM;
		Point p = null;
		for (int i = 0; i < RESOLUCION; i = tamCelda + i) {
			for (int j = 0; j < RESOLUCION; j = tamCelda + j) {
				if (esInicio(i/tamCelda, j/tamCelda)) {
					p = new Point(j + 10, i + 10);
					break;
				}
			}
		}
		return p;
	}
	
	public Point getPrimeraCasilla() {
		for (int i = 0; i < Template.TAM; i++)
			for (int j = 0; j < Template.TAM; j++)
				if (pieza[i][j] == 3)
					return new Point(i, j);
		return null;
	}
	
	public int countInicios(){
		int inicio = 0;
		for (int i = 0; i < Template.TAM; i++)
			for (int j = 0; j < Template.TAM; j++)
				if (pieza[i][j] == 4) 
					inicio++;
		return inicio;
	}
}
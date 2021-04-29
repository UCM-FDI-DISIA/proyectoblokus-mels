package model;

import java.awt.Color;

public class Template {

	public static final int TAM = 7;
	public static final int NUM_PIEZAS = 21;
	public static final int PUNTOS_GANADOR = 15;
	public static final int PUNTOS_CUADRADO = 20;
	protected static final int PIEZA = 3;
	protected static final int INICIO = 4;
	protected static final int LADO = 2;
	protected static final int ESQUINA = 1;

	
	// *
	private static final int[][] monomino = { 	
			 {0, 0, 0, 0, 0, 0, 0},   
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 1, 2, 1, 0, 0},
	         {0, 0, 2, 3, 2, 0, 0},
	         {0, 0, 1, 2, 1, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}
	};
	
	// **
	private static final int[][] domino = { 
			 {0, 0, 0, 0, 0, 0, 0},   
	         {0, 0, 1, 2, 1, 0, 0},
	         {0, 0, 2, 3, 2, 0, 0},
	         {0, 0, 2, 3, 2, 0, 0},
	         {0, 0, 1, 2, 1, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// ***
	private static final int[][] trinomino1 = { 
			{0, 0, 0, 0, 0, 0, 0},  
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 1, 2, 2, 2, 1, 0},
	        {0, 2, 3, 3, 3, 2, 0},
	        {0, 1, 2, 2, 2, 1, 0},
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// *
	// **
	private static final int[][] trinomino2 = { 			
			{0, 0, 0, 0, 0, 0, 0},   
	        {0, 0, 1, 2, 1, 0, 0},
	        {0, 0, 2, 3, 2, 1, 0},
	        {0, 0, 2, 3, 3, 2, 0},
	        {0, 0, 1, 2, 2, 1, 0},
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// ****
	private static final int[][] tetromino1 = {
			{0, 0, 0, 0, 0, 0, 0},  
	        {0, 0, 0, 0, 0, 0, 0},
	        {1, 2, 2, 2, 2, 1, 0},
	        {2, 3, 3, 3, 3, 2, 0},
	        {1, 2, 2, 2, 2, 1, 0},
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0}
	};
	
	// *
	// ***

	private static final int[][] tetromino2 = {
			 {0, 0, 0, 0, 0, 0, 0},
	         {0, 1, 2, 1, 0, 0, 0},
	         {0, 2, 3, 2, 2, 1, 0},
	         {0, 2, 3, 3, 3, 2, 0},
	         {0, 1, 2, 2, 2, 1, 0},
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}	
	};
	
	//  *
	// ***
	private static final int[][] tetromino3 = {
			{0, 0, 0, 0, 0, 0, 0}, 
	        {0, 0, 1, 2, 1, 0, 0},
	        {0, 1, 2, 3, 2, 1, 0},
	        {0, 2, 3, 3, 3, 2, 0},
	        {0, 1, 2, 2, 2, 1, 0},
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// **
	// **
	private static final int[][] tetromino4 = {
	         {0, 0, 0, 0, 0, 0, 0}, 
	         {0, 1, 2, 2, 1, 0, 0},
	         {0, 2, 3, 3, 2, 0, 0},
	         {0, 2, 3, 3, 2, 0, 0},
	         {0, 1, 2, 2, 1, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// **
	//  **
	private static final int[][] tetromino5 = {
			 {0, 0, 0, 0, 0, 0, 0}, 
	         {0, 1, 2, 2, 1, 0, 0},
	         {0, 2, 3, 3, 2, 1, 0},
	         {0, 1, 2, 3, 3, 2, 0},
	         {0, 0, 1, 2, 2, 1, 0},
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}
	};
	
	// *****
	private static final int[][] pentomino1 = {
			{0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0},
	        {1, 2, 2, 2, 2, 2, 1},
	        {2, 3, 3, 3, 3, 3, 2},
	        {1, 2, 2, 2, 2, 2, 1},
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0}		
	};
	
	// *
	// ****
	private static final int[][] pentomino2 = {
			{0, 0, 0, 0, 0, 0, 0},
	        {0, 1, 2, 1, 0, 0, 0},
	        {0, 2, 3, 2, 2, 2, 1},
	        {0, 2, 3, 3, 3, 3, 2},
	        {0, 1, 2, 2, 2, 2, 1},
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// **
	//  ***
	private static final int[][] pentomino3 = {
			 {0, 0, 0, 0, 0, 0, 0}, 
	         {1, 2, 2, 1, 0, 0, 0},
	         {2, 3, 3, 2, 2, 1, 0},
	         {1, 2, 3, 3, 3, 2, 0},
	         {0, 1, 2, 2, 2, 1, 0},
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}
	};
	
	// ** 
	// ***
	private static final int[][] pentomino4 = {
			{0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 1, 2, 2, 1, 0, 0},
	        {0, 2, 4, 3, 2, 1, 0},
	        {0, 2, 3, 3, 3, 2, 0},
	        {0, 1, 2, 2, 2, 1, 0},
	        {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// ***
	// * *
	private static final int[][] pentomino5 = {
			 {0, 0, 0, 0, 0, 0, 0},   
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 1, 2, 2, 2, 1, 0},
	         {0, 2, 3, 3, 3, 2, 0},
	         {0, 2, 3, 2, 3, 2, 0},
	         {0, 1, 2, 1, 2, 1, 0},
	         {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// ****
	//   *
	private static final int[][] pentomino6 = {
			{0, 0, 0, 0, 0, 0, 0}, 
	        {0, 0, 0, 0, 0, 0, 0},
	        {0, 1, 2, 2, 2, 2, 1},
	        {0, 2, 3, 3, 3, 3, 2},
	        {0, 1, 2, 2, 3, 2, 1},
	        {0, 0, 0, 1, 2, 1, 0},
	        {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// ***
	//	*
	//  *
	private static final int[][] pentomino7 = {
	         {0, 0, 0, 0, 0, 0, 0},   
	         {0, 1, 2, 2, 2, 1, 0},   
	         {0, 2, 3, 3, 3, 2, 0},
	         {0, 1, 2, 3, 2, 1, 0},
	         {0, 0, 2, 3, 2, 0, 0},
	         {0, 0, 1, 2, 1, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// *
	// *
	// ***
	private static final int[][] pentomino8 = {
	         {0, 0, 1, 2, 1, 0, 0},   
	         {0, 0, 2, 3, 2, 0, 0},  
	         {0, 0, 2, 3, 2, 2, 1},
	         {0, 0, 2, 3, 3, 3, 2},
	         {0, 0, 1, 2, 2, 2, 1},
	         {0, 0, 0, 0, 0, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}		
	};
	
	// **
	//  **
	//   *
	private static final int[][] pentomino9 = {
			 {0, 0, 0, 0, 0, 0, 0}, 
	         {0, 1, 2, 2, 1, 0, 0},
	         {0, 2, 3, 3, 2, 1, 0},
	         {0, 1, 2, 3, 3, 2, 0},
	         {0, 0, 1, 2, 3, 2, 0},
	         {0, 0, 0, 1, 2, 1, 0},
	         {0, 0, 0, 0, 0, 0, 0}
	};
	
	// *
	// ***
	//   *
	private static final int[][] pentomino10 = {
			 {0, 0, 0, 0, 0, 0, 0},
	         {0, 1, 2, 1, 0, 0, 0},
	         {0, 2, 3, 2, 2, 1, 0},
	         {0, 2, 3, 3, 3, 2, 0},
	         {0, 1, 2, 2, 3, 2, 0},
	         {0, 0, 0, 1, 2, 1, 0},
	         {0, 0, 0, 0, 0, 0, 0}	
	};
	
	// *
	// ***
	//  *
	private static final int[][] pentomino11 = {
	         {0, 0, 0, 0, 0, 0, 0}, 
	         {0, 1, 2, 1, 0, 0, 0},
	         {0, 2, 3, 2, 2, 1, 0},
	         {0, 2, 3, 3, 3, 2, 0},
	         {0, 1, 2, 3, 2, 1, 0},
	         {0, 0, 1, 2, 1, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}		 
	};
	
	//  *
	// ***
	//  *
	private static final int[][] pentomino12 = {
	         {0, 0, 0, 0, 0, 0, 0}, 
	         {0, 0, 1, 2, 1, 0, 0}, 
	         {0, 1, 2, 3, 2, 1, 0},
	         {0, 2, 3, 3, 3, 2, 0},
	         {0, 1, 2, 3, 2, 1, 0},
	         {0, 0, 1, 2, 1, 0, 0},
	         {0, 0, 0, 0, 0, 0, 0}
	};
	
	public static int[][][] plantilla = {monomino, domino, trinomino1,
			trinomino2, tetromino1, tetromino2, tetromino3, tetromino4, tetromino5, 
			pentomino1, pentomino2, pentomino3, pentomino4, pentomino5, pentomino6,
			pentomino7, pentomino8, pentomino9, pentomino10, pentomino11, pentomino12};
	
	public static boolean esCuadrado(Piece p) {
		return p.getPieza().equals(monomino);
	}
	
	public static Color getColor(int i) {
		switch(i) {
		case 0: 
			return Color.green;
		case 1:
			return Color.blue;
		case 2:
			return Color.yellow;
		case 3:
			return Color.red;
		}
		return null;
	}
}

package model;

public class Template {
	protected static final char PIEZA = 'P';
	protected static final char ESQUINA = 'E';
	protected static final char LADO = 'L';
	protected static final char NADA = ' ';
	// INICIO marca el primer cuadrado de PIEZA que se encuentra
	// Sirve para cuando haya que colocar las piezas al comienzo de la partida
	protected static final char INICIO = 'I';
	protected static final int TAM = 7;
	public static final int NUM_PIEZAS = 21;
	public static final int PUNTOS_GANADOR = 15;
	public static final int PUNTOS_CUADRADO = 20;
	public static final char ROJO = 'R';
	public static final char AMARILLO = 'A';
	public static final char AZUL = 'Z';
	public static final char VERDE = 'V';
	
	// *
	private static final char[][] monomino = { 	
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, LADO, INICIO, LADO, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// **
	private static final char[][] domino = { 
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, ESQUINA, NADA, NADA},
			{NADA, LADO, INICIO, PIEZA, LADO, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// ***
	private static final char[][] trinomino1 = { 
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, LADO, ESQUINA, NADA},
			{NADA, LADO, INICIO, PIEZA, PIEZA, LADO, NADA},
			{NADA, ESQUINA, LADO, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// *
	// **
	private static final char[][] trinomino2 = { 			
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, LADO, INICIO, LADO, ESQUINA, NADA},
			{NADA, NADA, LADO, PIEZA, PIEZA, LADO, NADA},
			{NADA, NADA, ESQUINA, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// ****
	private static final char[][] tetromino1 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{ESQUINA, LADO, LADO, LADO, LADO, ESQUINA, NADA},
			{LADO, INICIO, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{ESQUINA, LADO, LADO, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// *
	// ***

	private static final char[][] tetromino2 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, ESQUINA, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, LADO, INICIO, LADO, NADA},
			{NADA, NADA, ESQUINA, LADO, PIEZA, LADO, NADA},
			{NADA, NADA, LADO, PIEZA, PIEZA, LADO, NADA},
			{NADA, NADA, ESQUINA, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	//  *
	// ***
	private static final char[][] tetromino3 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, ESQUINA, LADO, INICIO, LADO, ESQUINA, NADA},
			{NADA, LADO, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{NADA, ESQUINA, LADO, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// **
	// **
	private static final char[][] tetromino4 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, LADO, INICIO, PIEZA, LADO, NADA},
			{NADA, NADA, LADO, PIEZA, PIEZA, LADO, NADA},
			{NADA, NADA, ESQUINA, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// **
	//  **
	private static final char[][] tetromino5 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, ESQUINA, NADA, NADA},
			{NADA, LADO, INICIO, PIEZA, LADO, ESQUINA, NADA},
			{NADA, ESQUINA, LADO, PIEZA, PIEZA, LADO, NADA},
			{NADA, NADA, ESQUINA, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// *****
	private static final char[][] pentomino1 = {
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, LADO, PIEZA, LADO, NADA, NADA},
			{NADA, NADA, LADO, PIEZA, LADO, NADA, NADA},
			{NADA, NADA, LADO, PIEZA, LADO, NADA, NADA},
			{NADA, NADA, LADO, PIEZA, LADO, NADA, NADA},
			{NADA, NADA, LADO, PIEZA, LADO, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA}
	};
	
	// *
	// ****
	private static final char[][] pentomino2 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{ESQUINA, LADO, LADO, LADO, LADO, ESQUINA, NADA},
			{LADO, PIEZA, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{ESQUINA, LADO, LADO, LADO, PIEZA, LADO, NADA},
			{NADA, NADA, NADA, ESQUINA, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// **
	//  ***
	private static final char[][] pentomino3 = {
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, LADO, INICIO, LADO, NADA, NADA},
			{NADA, ESQUINA, LADO, PIEZA, LADO, NADA, NADA},
			{NADA, LADO, PIEZA, PIEZA, LADO, NADA, NADA},
			{NADA, LADO, PIEZA, LADO, ESQUINA, NADA, NADA},
			{NADA, ESQUINA, LADO, ESQUINA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// ** 
	// ***
	private static final char[][] pentomino4 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{ESQUINA, LADO, LADO, LADO, ESQUINA, NADA, NADA},
			{LADO, INICIO, PIEZA, PIEZA, LADO, NADA, NADA},
			{ESQUINA, LADO, PIEZA, PIEZA, LADO, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// * *
	// ***
	private static final char[][] pentomino5 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, ESQUINA, NADA, NADA},
			{NADA, LADO, INICIO, PIEZA, LADO, NADA, NADA},
			{NADA, LADO, PIEZA, LADO, ESQUINA, NADA, NADA},
			{NADA, LADO, PIEZA, PIEZA, LADO, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// ****
	//   *
	private static final char[][] pentomino6 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{ESQUINA, LADO, LADO, LADO, LADO, ESQUINA, NADA},
			{LADO, INICIO, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{ESQUINA, LADO, LADO, PIEZA, LADO, ESQUINA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// ***
	//	*
	//  *
	private static final char[][] pentomino7 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, LADO, ESQUINA, NADA},
			{NADA, LADO, INICIO, PIEZA, PIEZA, LADO, NADA},
			{NADA, ESQUINA, LADO, PIEZA, LADO, ESQUINA, NADA},
			{NADA, NADA, LADO, PIEZA, LADO, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// *
	// *
	// ***
	private static final char[][] pentomino8 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, ESQUINA, NADA, NADA, NADA},
			{NADA, LADO, INICIO, LADO, NADA, NADA, NADA},
			{NADA, LADO, PIEZA, LADO, LADO, ESQUINA, NADA},
			{NADA, LADO, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{NADA, ESQUINA, LADO, LADO, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// **
	//  **
	//   *
	private static final char[][] pentomino9 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, LADO, ESQUINA, NADA, NADA},
			{NADA, LADO, INICIO, PIEZA, LADO, ESQUINA, NADA},
			{NADA, ESQUINA, LADO, PIEZA, PIEZA, LADO, NADA},
			{NADA, NADA, ESQUINA, LADO, PIEZA, LADO, NADA},
			{NADA, NADA, NADA, ESQUINA, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// *
	// ***
	//   *
	private static final char[][] pentomino10 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, ESQUINA, NADA, NADA, NADA},
			{NADA, LADO, INICIO, LADO, LADO, ESQUINA, NADA},
			{NADA, LADO, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{NADA, ESQUINA, LADO, LADO, PIEZA, LADO, NADA},
			{NADA, NADA, NADA, ESQUINA, LADO, ESQUINA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	// *
	// ***
	//  *
	private static final char[][] pentomino11 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, ESQUINA, LADO, ESQUINA, NADA, NADA, NADA},
			{NADA, LADO, INICIO, LADO, LADO, ESQUINA, NADA},
			{NADA, LADO, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{NADA, ESQUINA, LADO, PIEZA, LADO, ESQUINA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	//  *
	// ***
	//  *
	private static final char[][] pentomino12 = {
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, ESQUINA, LADO, INICIO, LADO, ESQUINA, NADA},
			{NADA, LADO, PIEZA, PIEZA, PIEZA, LADO, NADA},
			{NADA, ESQUINA, LADO, PIEZA, LADO, ESQUINA, NADA},
			{NADA, NADA, ESQUINA, LADO, ESQUINA, NADA, NADA},
			{NADA, NADA, NADA, NADA, NADA, NADA, NADA}
	};
	
	public static char[][][] plantilla = {monomino, domino, trinomino1,
			trinomino2, tetromino1, tetromino2, tetromino3, tetromino4, tetromino5, 
			pentomino1, pentomino2, pentomino3, pentomino4, pentomino5, pentomino6,
			pentomino7, pentomino8, pentomino9, pentomino10, pentomino11, pentomino12};
	
	public static boolean esCuadrado(Piece p) {
		return p.getPieza().equals(monomino);
	}
}

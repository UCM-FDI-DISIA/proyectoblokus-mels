package model;

public class Board {
	
	// Array bidemensional 20x20, Constructor, pintarTablero, (rellenarTablero)
	private static final int DIMENSION = 20;
	private String[][]arrayTablero;
	private static final String[] LETRAS= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
	private static String espacio=" ";
	int dimCelda=4;
	int dimMargen=1;
	String vertical="|";
	String horizontal="-";
	String interseccion=espacio;
	String interseccionVertical=espacio;
	String interseccionHorizontal="-";
	String esquina=espacio;
	String delCelda = repeat(horizontal, dimCelda);
	String delFila = interseccionVertical+repeat(delCelda+interseccion, DIMENSION-1)
	+delCelda+interseccionVertical;
	String bordeHor=esquina+repeat(delCelda+interseccionHorizontal,  DIMENSION-1)
	+delCelda+esquina;
	String margen=repeat(" ", dimMargen);
	String bordeLinea=String.format("%n%s%s%n", margen,bordeHor);
	String delLinea=String.format("%n%s%s%n", margen,delFila);
	
	StringBuilder str = new StringBuilder();
	public Board() {
		this.arrayTablero=new String[DIMENSION][DIMENSION];
	}
	
	public String inicioTablero() {
		
			for (int j = 0; j <= DIMENSION; j++) {
				
					str.append(margen).append(vertical);
				
				for (int i = 0; i < DIMENSION; i++) {
					
						str.append(centre("", dimCelda)).append(vertical);
					
				}
				if (j < DIMENSION ) 
					 str.append(espacio.repeat(2)+j+delLinea);
			    else 
			    	 str.append(bordeLinea);  
			}
		
		
		return str.toString();
	}
	
	public boolean posicionValida(int x, int y) {
		if(arrayTablero[x][y] == null && x <= DIMENSION && y <= DIMENSION) {
			return true;
		}else
			return false;
		
	}
	 public String getPositionToString(char [][] pieza, int x, int y) {
		 boolean vacio = posicionValida(x,y);
		 if(vacio) {
			 return pieza.toString();
		 }else
			 return "";
	 }
	private static String repeat(String elmnt, int length) {
		String result = "";
		for (int i = 0; i < length; i++) {
		   result += elmnt;
		}
		return result;
	}

	private static String centre(String text, int len) {
		   String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
		   float mid = (out.length()/2);
		   float start = mid - (len/2);
		   float end = start + len;
		   return out.substring((int)start, (int)end);
	}

	public String pintarPiezaEnTablero(char[][] p, int x, int y) {
		str.append(bordeLinea);
		for (int j = 0; j < DIMENSION; j++) {
			str.append(margen).append(vertical);
			for (int i = 0; i < DIMENSION; i++) {
				if(i==x && j==y) {
						colocarPieza(p, x, y);
					}else
						str.append(centre("", dimCelda)).append(vertical);
				
			}
			if (j < DIMENSION) 
				 str.append(espacio.repeat(2)+j+delLinea);
		    else 
		    	 str.append(bordeLinea);  
		}
		return str.toString();
		
	}
	// Devuelve el string de la pieza en la posicion que recorre el tablero (deberia ir en pieza y que 
	// devuelcal p+=color y nos deja acceder.
	public String piezaPorPosicion(char[][] pieza, int x, int y) {
		String p = "";
		for (int i = 0; i < pieza.length; i++) {
			for (int j = 0; j < pieza.length; j++) {
				if(i== x && j== y) {
					p+="R";
				}
			}
		}
		return p;
	}
	private void colocarPieza(char[][] p, int x, int y) {
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length; j++) {
				if(p[i][j]=='P' || p[i][j]=='I') {
					String pieza =piezaPorPosicion(p, i, j);
					str.append(centre(pieza, dimCelda)).append(vertical);
					
				}
			}
		}
		
	}
	
}

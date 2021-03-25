package objetos;

public class Tablero {
	
	// Array bidemensional 20x20, Constructor, pintarTablero, (rellenarTablero)
	private static final int DIMENSION = 20;
	private int[][]arrayTablero;
	
	public Tablero() {
		this.arrayTablero=new int[DIMENSION][DIMENSION];
	}
	
	public String pintarTablero() {
		int dimCelda=5;
		int dimMargen=1;
		String vertical="|";
		String horizontal="-";
		String interseccion=" ";
		String interseccionVertical=" ";
		String interseccionHorizontal="-";
		String esquina=" ";
		String delCelda = repeat(horizontal, dimCelda);
		String delFila = interseccionVertical+repeat(delCelda+interseccion, DIMENSION-1)
		+delCelda+interseccionVertical;
		String bordeHor=esquina+repeat(delCelda+interseccionHorizontal,  DIMENSION-1)
		+delCelda+esquina;
		String margen=repeat(" ", dimMargen);
		String bordeLinea=String.format("%n%s%s%n", margen,bordeHor);
		String delLinea=String.format("%n%s%s%n", margen,delFila);
		
		StringBuilder str = new StringBuilder();

		str.append(bordeLinea);
	
			
			for (int j = 0; j < DIMENSION; j++) {
				str.append(margen).append(vertical);
				for (int i = 0; i < DIMENSION; i++) {
					str.append(centre("", dimCelda)).append(vertical);
				}
				if (j != DIMENSION - 1) 
					 str.append(delLinea);
			    else 
			    	 str.append(bordeLinea);  
			}
		
		
		return str.toString();
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
	@Override
	public String toString() {
		return pintarTablero();
	}

}

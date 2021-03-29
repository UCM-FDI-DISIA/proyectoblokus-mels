package control;

import java.util.Scanner;

import model.*;
import player.Player;

public class Main {
	// Metodo inicio (LLama a pintar tablero y muestra piezas), actualizar tablero, reset tablero.
	public static void main(String[] args) {
	
		Board b = new Board();
		//System.out.println(b.inicioTablero());
		Player pl = new Player(Template.ROJO);
		System.out.println(pl);
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Elige una pieza y una posicion (x,y): ");
		String s = scanner.nextLine();
		String[] parameters = s.toLowerCase().trim().split(" ");
		int numPieza = Integer.parseInt(parameters[0]);
		int x = Integer.parseInt(parameters[1]);
		int y = Integer.parseInt(parameters[2]);
		char[][] pieza = Template.plantilla[numPieza];
		
		if(b.posicionValida(x, y)) {
			System.out.println(b.pintarPiezaEnTablero(pieza,x,y));
		}
	
	}

}

package control;

import model.*;
import player.Player;

public class Main {
	// Metodo inicio (LLama a pintar tablero y muestra piezas), actualizar tablero, reset tablero.
	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b.pintarTablero());
		Player pl = new Player(Template.ROJO);
		System.out.println(pl);
	}

}

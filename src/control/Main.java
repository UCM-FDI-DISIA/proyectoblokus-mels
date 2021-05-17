package control;

import model.*;


import view.SeleccionWindow;

public class Main {
	public static int numJugadores;
	
	
	// Metodo inicio (LLama a pintar tablero y muestra piezas), actualizar tablero, reset tablero.
	public static void main(String[] args) throws InterruptedException  {
		Game game = new Game();
		new SeleccionWindow(game);
		Thread.sleep(3500);
		game.run();
	}
	
}

package control;

import view.SeleccionWindow;

public class Main {
	public static int numJugadores;
	
	public static void main(String[] args) throws InterruptedException  {
		Game game = new Game();
		new SeleccionWindow(game);
		Thread.sleep(4000);
		game.run();
	}
}

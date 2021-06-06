package control;

import model.Game;
import view.SeleccionWindow;

public class Controller {

	Game game;
	
	public Controller(Game g) {
		game = g;
	}
	
	public void run() throws InterruptedException {
		new SeleccionWindow(game);
		Thread.sleep(4000);
		game.run();
	}
}

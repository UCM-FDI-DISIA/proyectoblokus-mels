package hebras;

import control.Game;
import view.SeleccionWindow;

public class HebraInicio extends Thread {
	private Game g;
	private HebraPrincipal hebra;
	
	public HebraInicio(Game game, HebraPrincipal h) {
		g = game;
		hebra = h;
	}
	
	public void run() {
		new SeleccionWindow(g, hebra);
	}
}

package hebras;

import control.Game;

public class HebraPrincipal extends Thread {
	private Game g;
	
	public HebraPrincipal(Game game) {
		g = game;
	}
	
	public void run(){
		g.run();
	}
}

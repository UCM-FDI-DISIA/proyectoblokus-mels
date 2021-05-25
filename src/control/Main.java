package control;

import hebras.HebraInicio;
import hebras.HebraPrincipal;

public class Main {
	public static int numJugadores;
	
	public static void main(String[] args) throws InterruptedException  {
		Game game = new Game();
		HebraPrincipal principal = new HebraPrincipal(game);
		principal.start();
		principal.wait();
		HebraInicio inicio = new HebraInicio(game, principal);
		inicio.start();
	}
}

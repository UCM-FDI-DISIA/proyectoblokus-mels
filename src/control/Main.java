package control;

import model.Game;

public class Main {
	
	public static void main(String[] args) throws InterruptedException  {
		Controller c = new Controller(new Game());
		c.run();
	}
}

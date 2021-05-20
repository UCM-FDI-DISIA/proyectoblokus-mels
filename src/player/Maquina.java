package player;

import java.awt.Color;

import estrategias.Strategy;

public class Maquina extends Player{

	private Strategy maquina;
	
	public Maquina (Color color, Strategy maquina) {
		super(color);
		this.maquina = maquina;
	}
	
	public boolean esMaquina() {
		return true;
	}
	
	public void addPiece() {
		maquina.addPiece();
	}
	
}

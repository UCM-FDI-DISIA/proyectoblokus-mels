package model.player;

import java.awt.Color;

import model.estrategias.Strategy;

public class Maquina extends Player{

	private Strategy maquina;
	
	public Maquina (Color color, Strategy maquina) {
		super(color);
		this.maquina = maquina;
	}
	
	public boolean esMaquina() {
		return true;
	}

	public void anyadirPieza() {
		// TODO Auto-generated method stub
		maquina.anyadirPieza();
	}
	
}

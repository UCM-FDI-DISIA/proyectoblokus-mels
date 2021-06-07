package player;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import model.Piece;
import model.Template;
import model.player.Player;

class PlayerTest {

	@Test
	void testCalculaPuntos() {
		//comprueba cuando no se han puesto las piezas
		int resultadoEsperado1 = -89;
		Player p = new Player(Color.BLUE);
		p.setUltima(p.getPiece(0));
		int resultadoObtenido1 = p.calculaPuntos();
		assertEquals(resultadoEsperado1, resultadoObtenido1);
		
		//comprueba cuando se han puesto todas las piezas y la ultima ha sido un monomino
		int resultadoEsperado2 = 20;
		for(int i = 1; i < p.numPiezas(); i++) 
			p.eliminarPieza(i);
		p.setUltima(p.getPiece(0));
		p.eliminarPieza(0);
		int resultadoObtenido2 = p.calculaPuntos();
		assertEquals(resultadoEsperado2, resultadoObtenido2);
		
		//comprueba cuando se han puesto todas las piezas y la ultima no ha sido un monomino
		int resultadoEsperado3 = 15;
		p.setUltima(new Piece(Template.plantilla[1],Color.CYAN));
		int resultadoObtenido3 = p.calculaPuntos();
		assertEquals(resultadoEsperado3, resultadoObtenido3);
	}

	@Test
	void testGetPiezaVentana() {
		//comprueba que no se ha detectado una pieza cuando no la está tocando
		int resultadoEsperado1 = -1;
		Player p = new Player(Color.BLUE);
		int resultadoObtenido1 = p.getPiezaVentana(510, 35);
		assertEquals(resultadoEsperado1, resultadoObtenido1);
		
		//comprueba que no se ha detectado una pieza cuando está en el tablero
		int resultadoEsperado2 = -1;
		int resultadoObtenido2 = p.getPiezaVentana(400, 35);
		assertEquals(resultadoEsperado2, resultadoObtenido2);
	}

}

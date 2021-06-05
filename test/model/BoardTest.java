package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testGetCasilla() {
		Board b = new Board();
		
		//Comprueba si se ha pinclado fuera del tablero
		Point resultadoEsperado1 = null;
		Point resultadoObtenido1 = b.getCasilla(1000,  1000);
		assertEquals(resultadoEsperado1, resultadoObtenido1);
		
		//Comprueba si se ha pinclado fuera del tablero
		Point resultadoEsperado2 = new Point (0, 0);
		Point resultadoObtenido2 = b.getCasilla(10,  140);
		assertEquals(resultadoEsperado2, resultadoObtenido2);
	}

	@Test
	void testSePuedeAnyadirPieza() {
		Board b = new Board();
		Piece p = new Piece(Template.plantilla[0], Color.BLACK);
		p.setInicio(p.getPrimeraCasilla().x, p.getPrimeraCasilla().y);
		
		//Comprueba que no se ponen piezas fuera del tablero
		boolean resultadoEsperado1 = false;
		boolean resultadoObtenido1 = b.sePuedeAnyadirPieza(-1, 40, p, true, new Point(0, 0));
		assertEquals(resultadoEsperado1, resultadoObtenido1);
		
		//Comprueba que no se ponen piezas donde ya hay otra
		boolean resultadoEsperado2 = false;
		b.colocarPieza(0, 0, p);
		boolean resultadoObtenido2 = b.sePuedeAnyadirPieza(0, 0, p, false, new Point(0, 0));
		assertEquals(resultadoEsperado2, resultadoObtenido2);
		
		//Comprueba que no se ponen piezas al lado si son del mismo color
		boolean resultadoEsperado3 = false;
		boolean resultadoObtenido3 = b.sePuedeAnyadirPieza(0, 1, p, false, new Point(0, 0));
		assertEquals(resultadoEsperado3, resultadoObtenido3);
		
		//Comprueba que se puede colocar
		boolean resultadoEsperado4 = true;
		boolean resultadoObtenido4 = b.sePuedeAnyadirPieza(1, 1, p, false, new Point(0, 0));
		assertEquals(resultadoEsperado4, resultadoObtenido4);
	}

}

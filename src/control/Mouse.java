package control;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import model.Board;
import model.Template;
import player.Player;
import view.GamePrinter;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener{
	private Player player;
	private Board board;
	private Point posicion;
	private GamePrinter gamePrinter;
	private int pieza;
	
	public Mouse(Player player, Board board,GamePrinter gamePrinter) {
		this.player = player;
		this.board = board;
		this.gamePrinter = gamePrinter;
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		board.addPieza(player.getPiece(pieza), posicion.x - 5, posicion.y - 5, true);
		//gamePrinter.createBoardPanel();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

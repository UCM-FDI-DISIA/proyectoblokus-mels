package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import model.Board;
import model.Piece;
import player.Player;

public class GamePrinter extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int X_init = 0;
	public static final int Y_init = 0;
	public static final int heigth = 900;
	public static final int width = 1500;
	public static final String nombrePestanya = "Blokus";
	private ImageIcon boardImageBoard;
	private Board board;
	private BoardPrinter boardPrinter;
	private Player player;
	private PlayerPrinter playerPrinter;
	private JLabel labelBoard;
	private JPanel playerPanel;
	private JPanel mainPanel;
	
	public GamePrinter(){
		super(nombrePestanya);
		board = new Board();
		boardPrinter = new BoardPrinter();
		player = new Player(Color.GREEN);
		playerPrinter = new PlayerPrinter();
		initGUI();
	}
	
	private void initGUI() {
		mainPanel = new JPanel();
		playerPanel = playerPrinter.printPlayer(player);
		boardImageBoard = new ImageIcon(boardPrinter.printBoard(board));
		labelBoard = new JLabel(boardImageBoard);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		mainPanel.add(labelBoard);
		mainPanel.add(playerPanel);
		
		this.addMouseListener(new MouseListener() {
			Point pointInicio = null;
			
			public void mouseClicked(MouseEvent e) {
				pointInicio = new Point(e.getX(), e.getY());
			}

			public void mousePressed(MouseEvent e) {
				mouseClicked(e);
			}

			public void mouseReleased(MouseEvent e) {
				int selectedPiece = playerPrinter.getPiezaVentana(player, pointInicio.x, pointInicio.y);
				if (selectedPiece == -1) System.out.println("No has cogido ninguna pieza, chaval");
				else {
					Piece piezaColoca = player.getPiece(selectedPiece);
					Point p = boardPrinter.getCasilla(board, e.getX(), e.getY());
					if (p == null) System.out.println("Fuerita del tablero");
					else {
						if (board.canAddPiece(p.x, p.y, piezaColoca, true)) {
							board.colocarPieza(p.x, p.y, piezaColoca);
							player.deletePiece(selectedPiece);
							printGame();
						}
					}
				}
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(mainPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	
//	
//	// Seria para volver a llamar al tablero y que se actualice
//	public void createBoardPanel() {
//		boardImageBoard.setImage(board.drawBoard());
//		labelBoard.repaint();
//		
//	}
	
	public void printGame() {
		labelBoard.setIcon(new ImageIcon(boardPrinter.printBoard(board)));
		mainPanel.remove(playerPanel);
		playerPanel = playerPrinter.printPlayer(player);
		mainPanel.add(playerPanel);
		mainPanel.validate();
	}
}

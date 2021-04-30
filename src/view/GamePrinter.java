package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import model.Board;
import model.Game;
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
	private BoardPrinter boardPrinter;
	private PlayerPrinter playerPrinter;
	private JLabel labelBoard;
	private JPanel playerPanel;
	private JPanel mainPanel;
	
	public GamePrinter(Game inicial){
		super(nombrePestanya);
		boardPrinter = new BoardPrinter();
		playerPrinter = new PlayerPrinter();
		initGUI(inicial);
	}
	
	private void initGUI(Game game) {
		mainPanel = new JPanel();
		playerPanel = playerPrinter.printPlayer(game.getCurrentPlayer());
		boardImageBoard = new ImageIcon(boardPrinter.printBoard(game.getCurrentBoard()));
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
				int selectedPiece = playerPrinter.getPiezaVentana(game.getCurrentPlayer(), pointInicio.x, pointInicio.y);
				if (selectedPiece == -1) JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pieza");
				else {
					Piece piezaColoca = game.getPiece(selectedPiece);
					Point p = boardPrinter.getCasilla(game.getCurrentBoard(), e.getX(), e.getY());
					if (p == null) {
						piezaColoca.deleteInicio();
						JOptionPane.showMessageDialog(null, "Estás fuera del tablero");
					}
					else {
						if (game.canAddPiece(p.x, p.y, piezaColoca, true)) {
							game.colocarPieza(p.x, p.y, piezaColoca);
							game.deletePiece(selectedPiece);
							game.pasaTurno();
							printGame(game);
						}
						else {
							piezaColoca.deleteInicio();
							JOptionPane.showMessageDialog(null, "No puedes colocar esa pieza ahí");
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
	
	public void printGame(Game game) {
		labelBoard.setIcon(new ImageIcon(boardPrinter.printBoard(game.getCurrentBoard())));
		mainPanel.remove(playerPanel);
		playerPanel = playerPrinter.printPlayer(game.getCurrentPlayer());
		mainPanel.add(playerPanel);
		mainPanel.validate();
		mainPanel.repaint();
	}
}

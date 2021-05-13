package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import model.Game;
import model.Piece;

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
	private Piece piezaColoca = null;
	private Point pointInicio = null;
	private int selectedPiece;
	
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
		mainPanel.setPreferredSize(new Dimension(1450, 800));
		
		this.addMouseListener(new MouseListener() {
			
			
			public void mouseClicked(MouseEvent e) {
				pointInicio = new Point(e.getX(), e.getY());
				selectedPiece = playerPrinter.getPiezaVentana(game.getCurrentPlayer(), pointInicio.x, pointInicio.y);
				if (selectedPiece == -1) JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pieza");
				else piezaColoca = game.getPiece(selectedPiece);
			}

			public void mousePressed(MouseEvent e) {
				mouseClicked(e);
			}

			public void mouseReleased(MouseEvent e) {
				
				
				if(piezaColoca != null) {
					Point p = boardPrinter.getCasilla(game.getCurrentBoard(), e.getX(), e.getY());
					if (p == null) {
						piezaColoca.deleteInicio();
						JOptionPane.showMessageDialog(null, "Estás fuera del tablero");
					}
					else {
						if (game.canAddPiece(p.x, p.y, piezaColoca)) {
							game.colocarPieza(p.x, p.y, piezaColoca);
							game.deletePiece(selectedPiece);
							game.cambiarPrimerTurno();
							game.pasaTurno();
							finishGame(game);
							piezaColoca = null;
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
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				repaint();
				PiecePrinter p = new PiecePrinter(); Graphics g = getGraphics();
			    g.drawImage(p.printPiece(piezaColoca), arg0.getX() - piezaColoca.getCoordsInicio().x,
			    arg0.getY() - piezaColoca.getCoordsInicio().y, 140, 140, null); 
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(piezaColoca != null && (arg0.getKeyChar() == 'g' || arg0.getKeyChar() == 'G')) {
					game.getCurrentPlayer().girar(selectedPiece);
					printGame(game);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
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
	
	public void finishGame(Game game) {
		int i;
		for (i = 0; i < game.getNumJugadores(); i++) {
			if (game.puedeColocarCurrentPlayer()) {
				printGame(game);
				break;
			}
			else {
				game.noPuedeColocar();
				printGame(game);
				JOptionPane.showMessageDialog(null, "El jugador " + game.getCurrentPlayer() + " no puede colocar.");
				game.pasaTurno();
			}
		}
		if (i == game.getNumJugadores())
			System.exit(0);
			
	}
}

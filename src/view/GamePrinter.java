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
import observers.BlokusObserver;

public class GamePrinter extends JFrame implements BlokusObserver{
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
	private Game game;
	
	public GamePrinter(Game inicial){
		super(nombrePestanya);
		boardPrinter = new BoardPrinter();
		playerPrinter = new PlayerPrinter();
		game = inicial;
		initGUI();
	}
	
	private void initGUI() {
		mainPanel = new JPanel();
		playerPanel = playerPrinter.dibujarPiezasJugador(game.getJugadorActual());
		boardImageBoard = new ImageIcon(boardPrinter.dibujarTablero(game.getTableroActual()));
		labelBoard = new JLabel(boardImageBoard);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		mainPanel.add(labelBoard);
		mainPanel.add(playerPanel);
		
		this.addMouseListener(new MouseListener() {
			
			public void mouseClicked(MouseEvent e) {
				pointInicio = new Point(e.getX(), e.getY());
				selectedPiece = playerPrinter.getPiezaVentana(game.getJugadorActual(), pointInicio.x, pointInicio.y);
				if (selectedPiece == -1) 
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna pieza");
				else piezaColoca = game.getPiece(selectedPiece);
			}

			public void mousePressed(MouseEvent e) {
				mouseClicked(e);
			}

			public void mouseReleased(MouseEvent e) {
				
				if(piezaColoca != null) {
					Point p = boardPrinter.getCasilla(game.getTableroActual(), e.getX(), e.getY());
					if (p == null) {
						piezaColoca.eliminarInicio();
						JOptionPane.showMessageDialog(null, "Estás fuera del tablero");
						
					}
					else {
						if (game.sePuedeAnyadir(p.x, p.y, piezaColoca)) {
							game.colocarPieza(p.x, p.y, piezaColoca);
							game.getJugadorActual().setUltima(piezaColoca);
							game.eliminarPieza(selectedPiece);
							game.cambiarPrimerTurno();
							game.pasaTurno();
							finJuego();
							piezaColoca = null;
						}
						else {
							piezaColoca.eliminarInicio();
							JOptionPane.showMessageDialog(null, "No puedes colocar esa pieza ahí");
						}
					}
				}
				
			}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
			
		});
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent arg0) {
				repaint();
				PiecePrinter p = new PiecePrinter(); 
				Graphics g = getGraphics();
			    g.drawImage(p.dibujarPieza(piezaColoca), arg0.getX() - piezaColoca.getCoordsInicio().x,
			    arg0.getY() - piezaColoca.getCoordsInicio().y, Piece.getRESOLUCION(), Piece.getRESOLUCION(), null); 
			}

			public void mouseMoved(MouseEvent arg0) {}
			
		});
		
		this.addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent arg0) {
				if(piezaColoca != null && (arg0.getKeyChar() == 'g' || arg0.getKeyChar() == 'G')) {
					game.girarPieza(selectedPiece);
				}
			}

			public void keyReleased(KeyEvent arg0) {}
			
			public void keyTyped(KeyEvent arg0) {}
			
		});
		
		this.add(mainPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	@Override
	public void cambioTablero() {
		labelBoard.setIcon(new ImageIcon(boardPrinter.dibujarTablero(game.getTableroActual())));
	}

	@Override
	public void cambioJugador() {
		mainPanel.remove(playerPanel);
		playerPanel = playerPrinter.dibujarPiezasJugador(game.getJugadorActual());
		mainPanel.add(playerPanel);
		mainPanel.validate();
		mainPanel.repaint();
	}

	@Override
	public void finJuego() {
		int i;
		for (i = 0; i < game.getNumJugadores(); i++) {
			if (game.puedeColocarJugadorActual()) {
				break;
			}
			else if(game.estaEliminado()) {
				game.pasaTurno();
			}
			else {
				game.noPuedeColocar();
				JOptionPane.showMessageDialog(null, "El jugador " + (game.getTurno() + 1)+ " no puede colocar.");
				game.pasaTurno();
			}
		}
		if (i == game.getNumJugadores()) {
			JOptionPane.showMessageDialog(null, game.getPuntos());
			System.exit(0);
		}
	}
}

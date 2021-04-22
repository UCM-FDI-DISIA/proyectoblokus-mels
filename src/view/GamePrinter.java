package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import model.Board;
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
	
	public GamePrinter(){
		super(nombrePestanya);
		board = new Board();
		boardPrinter = new BoardPrinter();
		player = new Player(Color.CYAN);
		playerPrinter = new PlayerPrinter();
		initGUI();
	}
	
	private void initGUI() {
		this.addMouseListener(new MouseListener() {
			
			public void mouseClicked(MouseEvent e) {
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		JPanel mainPanel = new JPanel();
		JPanel playerPanel = playerPrinter.printPlayer(player);
		boardImageBoard = new ImageIcon(boardPrinter.printBoard(board));
		labelBoard = new JLabel(boardImageBoard);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		mainPanel.add(labelBoard);
		mainPanel.add(playerPanel);
		
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
}

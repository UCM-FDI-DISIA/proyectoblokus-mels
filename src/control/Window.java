package control;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

import model.Board;
import model.Piece;
import model.Template;
import player.Player;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int X_init = 0;
	public static final int Y_init = 0;
	public static final int heigth = 900;
	public static final int width = 1500;
	public static final String nombrePestanya = "Blokus";
	private ImageIcon boardImageBoard;
	private ImageIcon boardImagePiece;
	private Board board;
	private Piece piece;
	private Player player;
	private JLabel labelBoard;
	private JLabel labelPiece;
	
	Window(){
		super(nombrePestanya);
		board = new Board();
		player = new Player(Color.CYAN);
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel();
		boardImageBoard = new ImageIcon(board.drawBoard());
		
		labelBoard = new JLabel(boardImageBoard);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		mainPanel.add(labelBoard);
		for (int i = 0; i < player.numPiezas(); i++) {
			boardImagePiece = new ImageIcon(player.piece(i));
			labelPiece = new JLabel(boardImagePiece);
			mainPanel.add(labelPiece);
		}
		this.add(mainPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	// Seria para volver a llamar al tablero y que se actualice
	private void createBoardPanel() {
		boardImageBoard.setImage(board.drawBoard());
		labelBoard.repaint();
		
	}
	
	private void createPiecesPanel() {
		
	}
}

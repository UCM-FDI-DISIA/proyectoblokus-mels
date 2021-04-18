package control;

import java.awt.*;

import javax.swing.*;

import model.Board;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int X_init = 0;
	public static final int Y_init = 0;
	public static final int heigth = 900;
	public static final int width = 1500;
	public static final String nombrePestanya = "Blokus";
	private ImageIcon boardImage;
	private Board board;
	private JLabel label;
	
	
	Window(){
		super(nombrePestanya);
		board = new Board();
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel();
		boardImage = new ImageIcon(board.drawBoard());
		label = new JLabel(boardImage);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		mainPanel.add(label);
		mainPanel.add(createPiecesPanel());
		this.add(mainPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	// Seria para volver a llamar al tablero y que se actualice
	private void createBoardPanel() {
		 boardImage.setImage(board.drawBoard());
		 label.repaint();
		
	}
	
	private JPanel createPiecesPanel() {
		JPanel piecesPanel = new JPanel();
		piecesPanel.setLayout(new GridLayout(6, 4, 5, 5));
		for (int i = 0; i < 21; i++) {
			JLabel pieza = new JLabel("Pieza " + (i + 1));
			pieza.setBackground(Color.GREEN);
			pieza.setForeground(Color.WHITE);
			pieza.setOpaque(true);
			piecesPanel.add(pieza);
		}
		return piecesPanel;
	}
}

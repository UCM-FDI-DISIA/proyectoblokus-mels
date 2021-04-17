package control;

import java.awt.*;

import javax.swing.*;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int X_init = 0;
	public static final int Y_init = 0;
	public static final int heigth = 900;
	public static final int width = 1500;
	public static final String nombrePestanya = "Blokus";
	
	Window(){
		super(nombrePestanya);
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		mainPanel.add(createBoardPanel());
		mainPanel.add(createPiecesPanel());
		this.add(mainPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	private JPanel createBoardPanel() {
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(20,20, 5, 5));
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				JLabel casilla = new JLabel("     ");
				casilla.setBackground(Color.LIGHT_GRAY);
				casilla.setOpaque(true);
				boardPanel.add(casilla);
			}
		}
		return boardPanel;
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

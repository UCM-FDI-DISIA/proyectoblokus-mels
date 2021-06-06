package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;

public class SeleccionWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Game game;
	
	public SeleccionWindow(Game game) {
		super("Seleccion Jugadores");
		this.game = game;
		initGUI();
	}

	private void initGUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton maquinaFacil = inicializaBoton(Color.GREEN, "Jugador vs Maquina : Facil");
		maquinaFacil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setMaquina(1);
				game.setNumJugadores(2);
				setVisible(false);
			}
		});
		
		JButton maquinaDificil = inicializaBoton(Color.RED, "Jugador vs Maquina : Dificil");
		maquinaDificil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setMaquina(2);
				game.setNumJugadores(2);
				setVisible(false);
			}
		});
		
		JButton dos = inicializaBoton(Color.ORANGE, "2 Jugadores");
		dos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setNumJugadores(2);
				setVisible(false);
			}
		});
		JButton tres = inicializaBoton(Color.CYAN, "3 Jugadores");
		tres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setNumJugadores(3);
				setVisible(false);
				
			}
		});
		JButton cuatro = inicializaBoton(Color.PINK, "4 Jugadores");
		cuatro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setNumJugadores(4);
				setVisible(false);
			}
		});
		panel.add(maquinaFacil);
		panel.add(maquinaDificil);
		panel.add(dos);
		panel.add(tres);
		panel.add(cuatro);
		add(panel);
		pack();
		setVisible(true);
		setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 125, 
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 100);
	}
	private JButton inicializaBoton(Color color, String txt) {
		JButton boton = new JButton(txt);
		boton.setBackground(color);
		boton.setPreferredSize(new Dimension(250,40));
		boton.setMaximumSize(new Dimension(250,40));
		boton.setMinimumSize(new Dimension(250,40));
		return boton;
	}

}

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;

public class SeleccionWindow extends JFrame{

	/**
	 * 
	 */
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
		JButton maquina = initBoton(Color.GRAY, "Jugador vs Maquina");
		maquina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setNumJugadores(2);
				setVisible(false);
			}
		});
		JButton dos = initBoton(Color.ORANGE, "2 Jugadores");
		dos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setNumJugadores(2);
				setVisible(false);
			}
		});
		JButton tres = initBoton(Color.CYAN, "3 Jugadores");
		tres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setNumJugadores(3);
				setVisible(false);
				
			}
		});
		JButton cuatro = initBoton(Color.PINK, "4 Jugadores");
		cuatro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setNumJugadores(4);
				setVisible(false);
				
			}
		});
		panel.add(maquina);
		panel.add(dos);
		panel.add(tres);
		panel.add(cuatro);
		add(panel);
		pack();
		setVisible(true);
		
	}
	private JButton initBoton(Color color, String txt) {
		JButton boton = new JButton(txt);
		boton.setBackground(color);
		boton.setPreferredSize(new Dimension(250,40));
		boton.setMaximumSize(new Dimension(250,40));
		boton.setMinimumSize(new Dimension(250,40));
		return boton;
	}

}

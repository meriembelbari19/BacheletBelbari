package domain;

	
	import javax.swing.JFrame;

	import javax.swing.*;

	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Fenetre class represents a window that displays the game board, score, and buttons for interacting with the game.
 */

	public class Fenetre extends JFrame {

		/**

		 * 

		 */

		private static final long serialVersionUID = 1L;
		private Board grid;
		private JButton button = new JButton("Recommencer");
		private JLabel label = new JLabel("Score : 0");
		private JLabel bestScore = new JLabel("Best score : 0");
		private JButton button2 = new JButton("Launch AI");
		private JButton button3 = new JButton("Switch to 5D");

		
		
		/**
		 * Constructs a new Fenetre object and sets up the window, game board, score label, and buttons.
		 */
		
		
		public Fenetre() {

			super("Morpion solitaire");
			setSize(600, 600);

			JPanel panel = new JPanel();

			panel.add(button, BorderLayout.SOUTH);
			panel.add(label, BorderLayout.NORTH);
			panel.add(button2, BorderLayout.SOUTH);
			panel.add(button3, BorderLayout.SOUTH);
			panel.add(bestScore, BorderLayout.NORTH);

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					grid.resetGame();
				}
			  });

			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					grid.launchBestAIInTheWorld();
				}
			  });

			  
			grid = new Board(label, button3, bestScore);
			panel.add(grid, label);
			this.add(panel);
			setVisible(true);
		}

		
		/**
		 * The main method launches the Fenetre window.
		 * @param args Command line arguments
		 */		
		
		
		public static void main(String[] args) {
			JFrame fenetre = new Fenetre();
		}
	}


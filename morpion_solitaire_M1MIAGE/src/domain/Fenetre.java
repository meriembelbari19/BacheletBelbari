package domain;

	
	import javax.swing.JFrame;

	import javax.swing.*;

	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



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



		public static void main(String[] args) {

			JFrame fenetre = new Fenetre();

		}

	}


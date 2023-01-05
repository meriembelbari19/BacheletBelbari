package domain;

import java.awt.BasicStroke;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.*;

/**
 * The Board class represents a game grid in which players can place tokens and try to align them to score points.
 * The grid also contains pre-filled cells with "cross" tokens and buttons and labels to display information about the game.
 *
 * @author Julie and Meriem 
 */

public class Board extends JPanel implements MouseListener {

	/** The number of rows and columns in the grid */
	private final int size = 25;

	public int nbAlignmentAuthorized = 1;

	private int x;

	private int bestScoreInInt = 0;

	private int y;

	Cell[][] cells;
	

	private int linecount = 0;

	private ArrayList<ArrayList<Cell>> alignedCells;
	
	private Board grid;

	
	private JLabel panel;

	private JButton button;

	private JLabel bestScore;


	/**
    * Creates a new instance of the Board class.
    *
    * @param panel the panel of the user interface
    * @param button the button of the user interface
    * @param bestScore the label displaying the best score
 */
	public Board(JLabel panel, JButton button, JLabel bestScore) {

		this.panel = panel;

		this.button = button;

		this.bestScore = bestScore;

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (nbAlignmentAuthorized == 1) {
					nbAlignmentAuthorized = 0;
					button.setText("Switch to 5T");
				}
				else {
					nbAlignmentAuthorized = 1;
					button.setText("Switch to 5D");
				}

			}
		  });

		this.setPreferredSize(new Dimension(820, 820));

		this.addMouseListener(this);

		this.cells = new Cell[size][size];

		this.alignedCells = new ArrayList<ArrayList<Cell>>();

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				cells[i][j] = new Cell(new Position(i, j));



			}



		}

		this.addCross(new Position(7, 9));

		this.addCross(new Position(7, 10));

		this.addCross(new Position(7,11));

		this.addCross(new Position(7, 12));

		this.addCross(new Position(8, 9));

		this.addCross(new Position(9, 9));

		this.addCross(new Position(10, 9));

		this.addCross(new Position(8, 12));

		this.addCross(new Position(9, 12));

		this.addCross(new Position(10, 12));

		this.addCross(new Position(10, 8));

		this.addCross(new Position(10, 7));

		this.addCross(new Position(10, 6));

		this.addCross(new Position(10, 13));

		this.addCross(new Position(10, 14));

		this.addCross(new Position(10, 15));

		this.addCross(new Position(11, 6));

		this.addCross(new Position(12, 6));

		this.addCross(new Position(13, 6));

		this.addCross(new Position(11, 15));

		this.addCross(new Position(12, 15));

		this.addCross(new Position(13, 15));

		this.addCross(new Position(13, 7));

		this.addCross(new Position(13, 8));

		this.addCross(new Position(13, 9));

		this.addCross(new Position(13, 14));

		this.addCross(new Position(13, 13));

		this.addCross(new Position(13, 12));

		this.addCross(new Position(14, 9));

		this.addCross(new Position(15, 9));

		this.addCross(new Position(16, 9));

		this.addCross(new Position(14, 12));

		this.addCross(new Position(15, 12));

		this.addCross(new Position(16, 12));

		this.addCross(new Position(16, 10));

		this.addCross(new Position(16, 11));

	}



	@Override

	public void paint(Graphics g) {
		
		this.panel.setText("Score : " + this.alignedCells.size());

		Graphics2D g2D = (Graphics2D) g;

		for (int i = 0; i < size; i++) {

			g2D.setColor(Color.LIGHT_GRAY);

			g2D.setStroke(new BasicStroke(1));

			g2D.drawLine(50, i * 30 + 50, 50 + 30 * (size - 1), i * 30 + 50);

			g2D.drawLine((i * 30 + 50), 50, i * 30 + 50, 50 + 30 * (size - 1));
			
			g2D.drawLine(i, i, i, i);

			for (int j = 0; j < size; j++) {

				if (cells[i][j].getHasCross()) {

					g2D.setColor(Color.PINK);

					g2D.fillOval(i * 30 + 50 - 5, j * 30 + 50 - 5, 10, 10);


				}
				
				for (int k = 0; k < size; k++) {
					for (int l = 0; l < size; l++) {
						if (cells[i][j].getLineCount() > 0) {
							if (cells[k][l].getLineCount() > 0) {
								if (cells[i][j].getLineCount() == cells[k][l].getLineCount()) {
									g2D.setColor(Color.BLACK);
									g2D.setStroke(new BasicStroke(3));
									g2D.drawLine(i*30+50, j*30+50, k*30+50, l*30+50);
								
								}
							}
						}
					}
				}
				for (ArrayList<Cell> list : alignedCells) {
					if (list.contains(cells[i][j])) {
						g2D.setColor(Color.BLACK);
						g2D.setStroke(new BasicStroke(3));
						list.sort( (a, b) -> a.getPosition().getX() - b.getPosition().getX());
						list.sort( (a, b) -> a.getPosition().getY() - b.getPosition().getY());
						g2D.drawLine(list.get(0).getPosition().getX()*30+50, list.get(0).getPosition().getY()*30+50, list.get(list.size() - 1).getPosition().getX()*30+50, list.get(list.size() - 1).getPosition().getY()*30+50);
					}
				}

			}

		}

		

		

		

		

	}

	





	



	// print method with seperator between cells

	public void printBoard() {

		for (int i = 0; i < size; i++) {



			System.out.print("| ");

			for (int j = 0; j < size; j++) {

				if (cells[i][j].getHasCross()) {

					System.out.print("X");

				} else {

					System.out.print("-");

				}

				System.out.print(" | ");

			}

			System.out.println();

		}

	}

	private boolean checkValue(int valueX, int valueY) {

		if (valueX < 0 || valueX >= size || valueY < 0 || valueY >= size) {

			return false;

		}

		return true;

	}

	public ArrayList<Cell> checkPointsByDirection(Position p, Direction d, int nbAlignedPoint) {

		int x = p.getX();

		int y = p.getY();

		ArrayList<Cell> alignedCells = new ArrayList<Cell>();

		alignedCells.add(this.cells[x][y]);

		int alignedPoint = 0;

		
		for (int i = 1; checkValue(x+d.getDx()*i, y+d.getDy()*i) && this.cells[x+d.getDx()*i][y+d.getDy()*i].getHasCross() && alignedCells.size() < 5; i++) {
			
			Cell cell = this.cells[x+d.getDx()*i][y+d.getDy()*i];

			if (cell.hasAlignementDirection(d)) {
				alignedPoint++;
				if(nbAlignedPoint <= alignedPoint) {
					break;
				}
			}
			alignedCells.add(cell);
			
		}

		for (int i = 1;  checkValue(x-d.getDx()*i, y-d.getDy()*i) && this.cells[x-d.getDx()*i][y-d.getDy()*i].getHasCross() && alignedCells.size() < 5; i++) {
			
			Cell cell = this.cells[x-d.getDx()*i][y-d.getDy()*i];

			if (cell.hasAlignementDirection(d)) {
				alignedPoint++;
				if(nbAlignedPoint <= alignedPoint) {
					break;
				}
			}
			alignedCells.add(cell);
			
		}

		return alignedCells;


	}



	public void addCheckingCross(Position p) {

		//Graphics2D g2D = (Graphics2D) g;

		if (cells[p.getX()][p.getY()].getHasCross()) {

			System.out.println("This cell already has cross");

			return;

		}

		for (Direction d : Direction.values()) {
			ArrayList<Cell> alignedCells = checkPointsByDirection(p, d, nbAlignmentAuthorized);
			if (alignedCells.size() == 5) {
				this.alignedCells.add(alignedCells);
				for (Cell cell : alignedCells) {
					cell.addAlignementDirection(d);
				}
				
				addCross(p);
				
			}
			
		}



			//int x = p.getX();

			//int y = p.getY();

			//grid.setColor(Color.PINK);

			//g2D.fillOval(x * 30 + 50 - 5, y * 30 + 50 - 5, 10, 10);

		}



	

	public void resetGame () {

		System.out.println("Hello World");

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				cells[i][j].setHasCross(false);
				cells[i][j].clearAlignementDirections();

			}

		}

		if (this.alignedCells.size()> this.bestScoreInInt)
		
		{

			this.bestScoreInInt = this.alignedCells.size();

			this.bestScore.setText("Best Score: " + this.bestScoreInInt);

		}

		

		this.alignedCells.clear();

		

		this.addCross(new Position(7, 9));

		this.addCross(new Position(7, 10));

		this.addCross(new Position(7,11));

		this.addCross(new Position(7, 12));

		this.addCross(new Position(8, 9));

		this.addCross(new Position(9, 9));

		this.addCross(new Position(10, 9));

		this.addCross(new Position(8, 12));

		this.addCross(new Position(9, 12));

		this.addCross(new Position(10, 12));

		this.addCross(new Position(10, 8));

		this.addCross(new Position(10, 7));

		this.addCross(new Position(10, 6));

		this.addCross(new Position(10, 13));

		this.addCross(new Position(10, 14));

		this.addCross(new Position(10, 15));

		this.addCross(new Position(11, 6));

		this.addCross(new Position(12, 6));

		this.addCross(new Position(13, 6));

		this.addCross(new Position(11, 15));

		this.addCross(new Position(12, 15));

		this.addCross(new Position(13, 15));

		this.addCross(new Position(13, 7));

		this.addCross(new Position(13, 8));

		this.addCross(new Position(13, 9));

		this.addCross(new Position(13, 14));

		this.addCross(new Position(13, 13));

		this.addCross(new Position(13, 12));

		this.addCross(new Position(14, 9));

		this.addCross(new Position(15, 9));

		this.addCross(new Position(16, 9));

		this.addCross(new Position(14, 12));

		this.addCross(new Position(15, 12));

		this.addCross(new Position(16, 12));

		this.addCross(new Position(16, 10));

		this.addCross(new Position(16, 11));

		repaint();

	}

	

	

	

	public void addCross(Position p) {

		if (p.getX() >= 0 && p.getX() < size && p.getY() >= 0 && p.getY() < size) {			

			if (p.getX() >= 0 && p.getX() < size && p.getY() >= 0 && p.getY() < size) {

				 cells[p.getX()][p.getY()].setHasCross(true);

			

			}

		}

	}


	public void launchBestAIInTheWorld() {

		boolean continueAI = true;
		ArrayList<ArrayList<Cell>> bestCells = new ArrayList<ArrayList<Cell>>();
		ArrayList<Direction> directions = new ArrayList<Direction>();

		while (continueAI) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					Position p = new Position(i, j);
					if (cells[p.getX()][p.getY()].getHasCross()) {
						continue;
					}
					for (Direction d : Direction.values()) {
						ArrayList<Cell> alignedCells = checkPointsByDirection(p, d, nbAlignmentAuthorized);
						if (alignedCells.size() == 5) {
							bestCells.add(alignedCells);
							directions.add(d);
						}
					}
				}
			}
			if (bestCells.size() > 0) {
				Random r = new Random();
				int low = 0;
				int high = bestCells.size() - 1;
				int result = r.nextInt(high - low) + low;
				Position p = bestCells.get(result).get(0).getPosition();
				addCross(p);
				for (Cell c : bestCells.get(result)) {
					c.addAlignementDirection(directions.get(result));
				}
				this.alignedCells.add(bestCells.get(result));
				repaint();
				bestCells.clear();
				directions.clear();
			}
			else {
				continueAI = false;
			}
		}

		
	}


	@Override

	public void mouseClicked(MouseEvent e) {

		this.x = e.getX();

		this.y = e.getY();

		System.out.println("mouseX" + x);

		System.out.println("mouseY" + y);

		System.out.println(" ");

		x = x / (30 ) - 1;

		y = y / (30 )- 1;

		System.out.println("mouseX" + x);

		System.out.println("mouseY" + y);

		Position p1 = new Position(x,y);

		addCheckingCross(p1);

		repaint();

	}



	@Override

	public void mousePressed(MouseEvent e) {


	}



	@Override

	public void mouseReleased(MouseEvent e) {

		// TODO();



	}



	@Override

	public void mouseEntered(MouseEvent e) {

		// TODO();



	}



	@Override

	public void mouseExited(MouseEvent e) {

		// TODO();



	}

}
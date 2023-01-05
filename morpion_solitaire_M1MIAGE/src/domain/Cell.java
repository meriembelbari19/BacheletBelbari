package domain;

import java.util.ArrayList;

/**
 * The Cell class represents a cell in the game grid. It contains information about the token in the cell, the
 * number of lines passing through the cell, the directions in which the cell is aligned with other cells, and
 * the position of the cell in the grid.
 *
 * @author Julie and Meriem
 */


public class Cell {
	
	private boolean hasCross;
    private ArrayList<Direction> alignementDirection;
    private Position position;
	

    public Cell(Position position) {
        this.hasCross = false;
        this.alignementDirection = new ArrayList<Direction>();
        this.position = position;
    } 

    public boolean getHasCross() {
        return this.hasCross;
    }

    public void setHasCross(boolean hasCross) {
        this.hasCross = hasCross;
    }
    

    public void addAlignementDirection(Direction direction) {
        this.alignementDirection.add(direction);
    }

    public boolean hasAlignementDirection(Direction direction) {
        return this.alignementDirection.contains(direction);
    }

    public Position getPosition() {
        return this.position;
    }

    public void clearAlignementDirections() {
        this.alignementDirection.clear();
    }
  

}

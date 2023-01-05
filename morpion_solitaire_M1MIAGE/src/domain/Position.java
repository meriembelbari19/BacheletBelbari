package domain;

/**
 * The Position class represents a position on the game grid with x and y coordinates.
 */



public class Position {
	private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}



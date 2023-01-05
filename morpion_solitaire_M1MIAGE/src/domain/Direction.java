package domain;


/**
 * The Direction enum represents the possible directions in which a cell can be aligned with another cell.
 * It contains the x and y offsets for each direction.
 */


public enum Direction {
    VERTICAL(0,-1),
    HORIZONTAL(-1,0),
    DIAGONAL_RIGHT(1,1),
    DIAGONAL_LEFT(1,-1);

    private int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
package domain;

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

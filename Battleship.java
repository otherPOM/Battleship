package battleship;

public class Battleship {
    private int x;
    private int start;
    private int end;
    private boolean vertical;

    public Battleship(int x, int start, int end, boolean vertical) {
        this.x = x;
        this.start = start;
        this.end = end;
        this.vertical = vertical;
    }

    public int getX() {
        return x;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isVertical() {
        return vertical;
    }
}

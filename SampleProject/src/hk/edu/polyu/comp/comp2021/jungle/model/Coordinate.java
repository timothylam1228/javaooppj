package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * Coordinate of chess
 */
public class Coordinate {
    private int x, y;

    /**
     *Constructor
     */
    public Coordinate() {
    }

    /**
     * @param x x coordinate
     * @param y y coordinate
     */
    public Coordinate(int x, int y) {
        SetCoordinate(x, y);

    }

    /**
     * @param x x coordinate
     * @param y y coordinate
     */
    public void SetCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return   x coordinate
     */
     public int GetX() {
        return x;
    }

    /**
     * @return y coordinate
     */
     public int GetY() {
        return y;
    }



}

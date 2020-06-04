package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * initialize river side
 */
public class RiverSide {

    /**
     * there are 17 river side
     */
    public static final int INT = 17;
    private static final Coordinate[] coordinates = new Coordinate[INT];


    /**
     * @param riverSideBoard use riverSideBoard to store river side
     * @param x corrdinate x of river side
     * @param y corrdinate y of river side
     */
    static void setCoordinates(int riverSideBoard, int x, int y) {
        coordinates[riverSideBoard] = new Coordinate(x, y);

    }

    /**
     * @param x corrdinate x
     * @param y corrdinate y
     * @return that (x,y) location is river side or not
     */
    static boolean isRiverSide(int x, int y) {
        for (int i = 0; i < INT; i++) {
            if (x == coordinates[i].GetX() && y == coordinates[i].GetY()) return true;
        }
        return false;
    }

}

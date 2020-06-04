package hk.edu.polyu.comp.comp2021.jungle.model;


/**
 * initialize river
 */
public class River {
    /**
     * 12 blocks that containing river
     */
    public static final int INT = 12;
    private static final Coordinate[] coordinates = new Coordinate[INT];


    /**
     * @param waterBoard board that store river
     * @param x water x corrdinate
     * @param y water y corrdinate
     */
    static void setCoordinates(int waterBoard, int x, int y) {
        coordinates[waterBoard] = new Coordinate(x, y);

    }

    /**
     * @param x x corrdinate
     * @param y y corrdinate
     * @return that corrdinate(x,y) is river or not , if yes return true else return false
     */
    static boolean isRiver(int x, int y) {
        for (int i = 0; i < INT; i++) {
            if (x == coordinates[i].GetX() && y == coordinates[i].GetY()) return true;
        }
        return false;
    }

    /**
     * @return water char
     */
    public static char getWaterChar() {
        return '河';
    }

}

package hk.edu.polyu.comp.comp2021.jungle.model;


/**
 * initialize game board
 */
public class GameBoard {
    private char[][] jungleBoard = new char[9][7];

    private static final char LAND = ' ';


    /**
     * print game board
     */
    public GameBoard() {
        int waterBoard = 0;
        int riverSideBoard = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i > 2 && i < 6)) {
                    if ((j > 0 && j < 6 && j != 3)) {
                        River.setCoordinates(waterBoard, j, i);
                        this.Insert(River.getWaterChar(), j, i);
                        waterBoard += 1;
                        continue;
                    } else {
                        RiverSide.setCoordinates(riverSideBoard, j, i);
                        riverSideBoard += 1;
                    }
                }

                if ((i == 2 || i == 6) && ((j > 0 && j < 6 && j != 3))) {
                    RiverSide.setCoordinates(riverSideBoard, j, i);
                    riverSideBoard += 1;
                }

                this.Insert(LAND, j, i);
            }
        }

    }


    /**
     * @param x x coordinate of the chess that want to get
     * @param y y coordinate of the chess that want to get
     * @return the board location with x and y
     */
    public char getChessChar(int x, int y) {
        return jungleBoard[y][x];
    }

    /**
     * @param x river x coordinate
     * @param y river y coordinate
     * @return  is that coordinate river or not
     */
    public boolean isRiver(int x, int y) {
        return River.isRiver(x, y);
    }

    /**
     * @param x river side x coordinate
     * @param y river side y coordinate
     * @return  is that coordinate river side or not
     */
    public boolean isRiverSide(int x, int y) {
        return RiverSide.isRiverSide(x, y);
    }

    /**
     * @param c chess display char
     * @param x chess x coordinate
     * @param y chess y coordinate
     */
    public void Insert(char c, int x, int y) {
        if (x != -1 && y != -1)
            jungleBoard[y][x] = c;

    }

    /**
     * @return current game board0
     */
    public char[][] getJungleBoard() {
        return jungleBoard;
    }


}


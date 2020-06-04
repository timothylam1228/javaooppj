package hk.edu.polyu.comp.comp2021.jungle.model;


/**
 * initialize the chess
 */
public class Chess extends Coordinate {
    private final char[] CHESS = {'鼠', '貓', '狗', '狼', '豹', '虎', '獅', '象'};
    private int rank;


    /**
     * @param Chess chess
     * @param x x coordinate
     * @param y y coordinate
     */
    public Chess(int x, int y) {
        super(x, y);

    }

    /**
     * @param x x coordinate
     * @param y y coordinate
     * @param c display of chess
     */
    public Chess(int x, int y, char c) {
        this(x, y);
        for (int i = 0; i < CHESS.length; i++) {
            if (CHESS[i] == c)
                this.rank = i;
        }
    }

    /**
     * @return chess rank
     */
    public char GetChess() {
        return CHESS[rank];
    }

    /**
     * @param rank set chess rank
     */
    public void SetRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return chess ranking
     */
     public int GetRank() {
        return rank;
    }

}

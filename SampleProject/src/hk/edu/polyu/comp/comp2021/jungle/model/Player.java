package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * initialize player
 */
public class Player {

    private String name;
    private Chess[] chess = new Chess[8];
    private Dens dens = new Dens();
    private Traps[] trap = new Traps[3];

    /**
     * @param x Create chess at corrdinate x
     * @param y Create chess at corrdinate y
     * @param rank Create chess with rank
     */
    public void ChessCreator(int x, int y, int rank) {
        chess[rank] = new Chess(x, y);
        chess[rank].SetRank(rank);
    }

    /**
     * @param index index
     * @param x create trap with corrdinate x
     * @param y create trap with corrdinate y
     */
    public void setTrapsCoordinate(int index, int x, int y) {
        trap[index] = new Traps();
        trap[index].SetCoordinate(x, y);
    }

    /**
     * @param x check that corrdinate x have trap or not
     * @param y check that corrdinate y have trap or not
     * @return if have trap return true else return false
     */
    public boolean isTraps(int x ,int y){
        for (int i = 0; i < 3; i++) {
            if (x == trap[i].GetX() && y == trap[i].GetY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param x check that corrdinate x have den or not
     * @param y check that corrdinate y have den or not
     * @return if have den return true else return false
     */
    public boolean isDen(int x ,int y){
        return x == dens.GetX() && y == dens.GetY();
    }


    /**
     * @param x create den with corrdintate x
     * @param y create den with corrdinate y
     */
    public void setDenCoordinate(int x, int y) {
        dens.SetCoordinate(x, y);
    }

    /**
     * @param x check corrdinate x and y is that his chess
     * @param y check corrdinate x and y is that his chess
     * @return return true if that is his chess else false
     */
    public boolean isYourOwnChess(int x, int y) {

        for (int i = 0; i < 8; i++) {
            if (x == this.GetX(i) && y == this.GetY(i)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param name set palyer name
     */
    public void SetName(String name) {
        this.name = name;
    }

    /**
     * @return returen palyer name
     */
    public String GetName() {
        return name;
    }

    /**
     * @param rank chess ranking
     * @return  that chess ranking
     */
    public char GetChess(int rank) {
        return chess[rank].GetChess();
    }

    /**
     * @param oriX Original chess corrdinate X
     * @param oriY Original chess corrdinate y
     * @param newX Target chess corrdinate X
     * @param newY Target chess corrdinate y
     */
    public void chessCoordinateUpdate(int oriX, int oriY, int newX, int newY) {
        int rank = -1;

        for (int i = 0; i < 8; i++) {
            if (oriX == this.GetX(i) && oriY == this.GetY(i)) {
                rank = i;
            }
        }

        if (rank != -1)
            chess[rank].SetCoordinate(newX, newY);
    }


    /**
     * @param rank chess rank
     * @return  that chess ranking corrdinate x
     */
    public int GetX(int rank) {
        return chess[rank].GetX();
    }
    /**
     * @param rank chess rank
     * @return  that chess ranking corrdinate y
     */
    public int GetY(int rank) {
        return chess[rank].GetY();
    }
}

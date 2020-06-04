package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing chess class
 */
public class ChessTest extends Coordinate {

    /**
     * Test getChess method
     */
    @Test
    public void getChess() {
        Chess chess = new Chess(1,2);
        Chess chess1 = new Chess(1,2,'貓');
        assertEquals(chess.GetX(),1);
        assertEquals(chess.GetY(),2);
        chess.SetRank(1);
        assertEquals(chess.GetRank(),1);
        assertEquals(chess.GetChess(),'貓');
    }

}
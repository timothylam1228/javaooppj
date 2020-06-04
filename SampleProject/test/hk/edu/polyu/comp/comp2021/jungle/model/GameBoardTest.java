package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing GameBoard
 */
public class GameBoardTest {

    /**
     * Get chess character
     */
    @Test
    public void getChessChar() {
        GameBoard board = new GameBoard();
        board.Insert('a',1,2);
        board.Insert('b',2,1);
        assertEquals(board.getChessChar(1,2),'a');
    }

    /**
     * Check if there is river or not
     */
    @Test
    public void isRiver() {
        GameBoard board = new GameBoard();
        board.Insert('a',1,2);
        assertFalse(board.isRiver(1,2));
    }

    /**
     * Check if there is river side or not
     */
    @Test
    public void isRiverSide() {
        GameBoard board = new GameBoard();
        board.Insert('a',1,2);
        assertTrue(board.isRiverSide(1,2));
    }


    /**
     * get Jungle Board
     */
    @Test
    public void getJungleBoard() {
        GameBoard board = new GameBoard();
        char[][] jungleBoard = new char[9][7];
        board.Insert('a',1,2);
        assertNotEquals(board.getJungleBoard(),jungleBoard);

    }
}
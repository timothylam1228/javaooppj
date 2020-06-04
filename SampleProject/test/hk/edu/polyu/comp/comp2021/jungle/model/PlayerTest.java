package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Player class
 */
public class PlayerTest {


    /**
     * Create cheass
     */
    @Test
    public void chessCreator() {
        Player corrdinate = new Player();
        corrdinate.ChessCreator(1,2,1);
    }

    /**
     * Setup the traps coordinate
     */
    @Test
    public void setTrapsCoordinate() {
        Player chesscreate = new Player();
        chesscreate.setTrapsCoordinate(1,2,3);
    }

    /**
     * check if the coordinate is traps or not
     */
    @Test
    public void isTraps() {
        Player chesscreate = new Player();
        chesscreate.setTrapsCoordinate(1,1,2);
        //assertFalse(chesscreate.isTraps(1,2));


    }

    /**
     * check if the coordinate is den or not
     */
    @Test
    public void isDen() {
        Player chesscreate = new Player();
        chesscreate.ChessCreator(0,0,0);
        chesscreate.setDenCoordinate(1,2);
        assertTrue(chesscreate.isDen(1,2));
    }


    /**
     * Test chess is player or not
     */
    @Test
    public void isYourOwnChess() {

    }

    /**
     * get palyer name
     */
    @Test
    public void GetName() {
        final String name = "SERVER";
        Player player = new Player();
        player.SetName(name);
        assertEquals(name, player.GetName());
    }

    /**
     * Get user chess is what animal
     */
    @Test
    public void getChess() {
        Player b = new Player();
        b.ChessCreator(1,1,1 );
        b.GetChess(1);
    }

    /**
     * get chess y coordinate
     */
    @Test
    public void getY() {
        Player b = new Player();
        b.ChessCreator(1,1,1 );
       assertEquals(b.GetY(1),1);
    }

    /**
     * get chess x coordinate
     */
    @Test
    public void getX() {
        Player b = new Player();
        b.ChessCreator(1,1,1 );
        assertEquals(b.GetX(1),1);
    }
}
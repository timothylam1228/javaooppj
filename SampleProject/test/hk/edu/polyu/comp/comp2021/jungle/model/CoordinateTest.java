package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Coordinate testing
 */
public class CoordinateTest {

    /**
     * setup Coordinate
     */
    @Test
    public void setCoordinate() {
        Coordinate corrdinate = new Coordinate();
        corrdinate.SetCoordinate(1,2);
        assertEquals(corrdinate.GetX(),1);
        assertEquals(corrdinate.GetY(),2);


    }

}
package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static hk.edu.polyu.comp.comp2021.jungle.model.Traps.getTrapsChar;
import static org.junit.Assert.*;

/**
 * Test trap
 */
public class TrapsTest {

    /**
     * get trap character
     */

    private static final char trapChar = '阱';

    /**
     * return trap char
     */
    @Test
    public void test() {
        assertEquals(getTrapsChar(),trapChar);
    }



}
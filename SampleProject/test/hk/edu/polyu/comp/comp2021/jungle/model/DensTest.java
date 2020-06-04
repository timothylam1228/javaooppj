package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static hk.edu.polyu.comp.comp2021.jungle.model.Dens.getDenChar;
import static org.junit.Assert.*;

/**
 * Dens test
 */
public class DensTest {

    /**
     * return dens char 穴
     */

    private static final char denChar = '穴';

    /**
     * Test getDenChar()
     */
    @Test
    public void test() {

        assertEquals(getDenChar(), denChar);
    }
}
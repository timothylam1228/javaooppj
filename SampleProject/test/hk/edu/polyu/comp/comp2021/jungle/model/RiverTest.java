package hk.edu.polyu.comp.comp2021.jungle.model;
import org.junit.Test;

import static hk.edu.polyu.comp.comp2021.jungle.model.River.getWaterChar;
import static org.junit.Assert.*;

/**
 * river testing
 */
public class RiverTest {

    private static final char riverchar = '河';

    /**
     * test getWaterChar()
     */
    @Test
    public void test(){
        assertEquals(getWaterChar(),riverchar);
    }
}
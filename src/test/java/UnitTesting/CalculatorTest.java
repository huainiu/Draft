package UnitTesting;
//import static org.junit.Assert.*;
//import junit.framework.Misc.Test;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Michael.Shreiber on 3/11/14.
 */
public class CalculatorTest {

    @Test
    @Ignore("experimantal project only for learning purposes.")
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }


}
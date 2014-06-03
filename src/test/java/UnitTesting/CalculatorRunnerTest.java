package UnitTesting;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Normally JUnit will detect the right test runner to use without asking you, based on the
 * test-case you provide. If you want to force it to use any particular runner you need to use
 * the  @RunWith annotation as shown in the following listing.
 *
 *
 */

@RunWith(value=org.junit.internal.runners.JUnit38ClassRunner.class)
@Ignore ("experimantal project only for learning purposes.")
public class CalculatorRunnerTest extends junit.framework.TestCase {

    @Test
    @Ignore("experimantal project only for learning purposes.")
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }


}

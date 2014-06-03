package UnitTesting;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Michael.Shreiber on 3/13/14.
 */

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {CalculatorTest.class, ParameterizedTest.class})
@Ignore("experimantal project only for learning purposes.")
public class AllTests {
    //The point is that by specifying values of the @SuiteClasses
    //you are able to run all that tests.
    //In this specific case CalculatorTest and ParameterizedTest will run.
}

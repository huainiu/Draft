package UnitTesting;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Michael.Shreiber on 3/11/14.
 */

//You need to denote the  @RunWith annotation to use the Parameterized test-runner
@RunWith(value=Parameterized.class)
public class ParameterizedTest {
    private double expected;
    private double valueOne;
    private double valueTwo;

    //Then we declare some local instance variables we are going to use in our tests
    //This method is used to provide the input and output data for the parameterized
    //tests. This method needs to be  public ,  static and return a  Collection instance by
    //signature. As we want to test the  add method of our  Calculator program we provide three
    //parameters –  expected value, and two values that we will add together.
    @Parameterized.Parameters
    public static Collection dataParameters() {

        //and we provide the obligatory  @Parameters- annotated method
        return Arrays.asList(new Object[][]{
                {2, 1, 1}, //expected, valueOne, valueTwo
                {3, 2, 1},
                {4, 3, 1},
        });
    }


    //we specify the obligatory constructor for the test. Note that this time our test-case does not have a no-
    //argument constructor, but instead has a constructor that accepts parameters for the test.
    public ParameterizedTest(double expected,
                             double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    //we finally implement the  sum @Misc.Test method, that instantiates the  Calculator program
    @Test
    @Ignore("experimantal project only for learning purposes.")
    public void sum() {
        //and asserts against the parameters we have provided
        Calculator calc = new Calculator();
        assertEquals(expected, calc.add(valueOne, valueTwo), 0);
    }

}

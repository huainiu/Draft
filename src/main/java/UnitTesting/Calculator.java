package UnitTesting;

import DesignPatternsNotes.FactorySimple.ClamPizza;

/**
 * Created by Michael.Shreiber on 3/11/14.
 */
public class Calculator {

    public double add (double a, double b){
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(1, 5));
    }

}

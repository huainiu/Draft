package DesignPatternsNotes.Decorator;

/**
 * Created by Michael.Shreiber on 2/14/14.
 */
public class CoffeeHouse {

    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.description + ", price: " + espresso.cost());

        Beverage nesscaffe = new Nesscaffe();
        nesscaffe = new Mocha(nesscaffe);
        nesscaffe = new Mocha(nesscaffe);
        nesscaffe = new Soy(nesscaffe);
        System.out.println(nesscaffe.description + ", price: " + nesscaffe.cost());






    }
}

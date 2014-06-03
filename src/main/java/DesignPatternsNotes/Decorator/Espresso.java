package DesignPatternsNotes.Decorator;

/**
 * Created by Michael.Shreiber on 2/14/14.
 */
public class Espresso extends Beverage {

    public Espresso(){
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

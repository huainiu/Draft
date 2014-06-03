package DesignPatternsNotes.Decorator;

/**
 * Created by Michael.Shreiber on 2/14/14.
 */
public class Mocha extends CondimentDecorator{
    //We are going to instantiate Mocha via constructor with a reference to a Beverage using
    //the instance variable to hold the bevarege we are wrapping.
    Beverage beverage;

    public Mocha (Beverage beverage){
        this.beverage = beverage;
        this.description = getDescription();
    }

    public String getDescription(){
        return beverage.getDescription() + ", Mocha";
    }

    public double cost(){
        return .20 + beverage.cost();
    }


}

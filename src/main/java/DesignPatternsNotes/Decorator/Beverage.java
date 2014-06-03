package DesignPatternsNotes.Decorator;

/**
 * Created by Michael.Shreiber on 2/14/14.
 */
public abstract class Beverage {
    String description = "N/A";

    public String getDescription(){
        return description;
    }

    public abstract double cost();



}

package DesignPatternsNotes.Decorator;

/**
 * Created by Michael.Shreiber on 2/14/14.
 */
public class Nesscaffe extends Beverage {

    public Nesscaffe(){
        this.description = "Nesscaffe";
    }

    @Override
    public double cost() {
        return .89;
    }
}

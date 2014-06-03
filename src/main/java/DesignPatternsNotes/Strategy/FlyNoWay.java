package DesignPatternsNotes.Strategy;

/**
 * Created by Michael.Shreiber on 2/8/14.
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}

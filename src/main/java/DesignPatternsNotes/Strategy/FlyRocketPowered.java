package DesignPatternsNotes.Strategy;

/**
 * Created by Michael.Shreiber on 2/8/14.
 */
public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}

package DesignPatternsNotes.Strategy;

/**
 * Created by Michael.Shreiber on 2/8/14.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack! Quack! Quack!");
    }
}

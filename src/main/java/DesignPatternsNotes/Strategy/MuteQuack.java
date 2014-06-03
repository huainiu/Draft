package DesignPatternsNotes.Strategy;

/**
 * Created by Michael.Shreiber on 2/8/14.
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println(".....");
    }
}

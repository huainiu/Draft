package DesignPatternsNotes.Strategy;

/**
 * Created by Michael.Shreiber on 2/8/14.
 */
public class MallardDuck extends Duck {

    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("I am the Mallard Duck!");
    }
}

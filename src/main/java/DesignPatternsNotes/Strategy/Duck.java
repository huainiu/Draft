package DesignPatternsNotes.Strategy;

/**
 * Created by Michael.Shreiber on 2/8/14.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public Duck() {
    }

    void performQuack() {
        quackBehavior.quack();
    }

    void performFly() {
        flyBehavior.fly();
    }

    abstract void display();

    void swim() {
        System.out.println("I'm swimming. (all ducks can swim)");
    }
}
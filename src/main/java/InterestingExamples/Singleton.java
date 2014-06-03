package InterestingExamples;

import java.util.Random;

public class Singleton {

    // : access/Lunch.java
    // Demonstrates class access specifiers. Make a class
    // effectively private with private constructors:

    static private Singleton me = null;
    private int x;

    private Singleton() {
        Random rand = new Random();
        x = rand.nextInt();
    }

    // (1) Allow creation via static method:
    public static Singleton makeSingleton() {
        if (me == null) {
            me = new Singleton();
        }
        return me;
    }

    public void print() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        Singleton x = Singleton.makeSingleton();
        x.print();
        Singleton.makeSingleton().print();

    }


}

package DesignPatternsNotes.Singleton;

import java.util.Random;

/**
 * Created by Michael.Shreiber on 2/20/14.
 */
public class Singleton_Optimized {
    private static int i;

    //The volatile keyword ensures that multiple threads handle the uniqueInstance variable correctly
    //when it is being initialized to the Singleton instance.
    private static volatile Singleton_Optimized uniqueInstance;

    public int getValue() {
        return i;
    }

    private Singleton_Optimized() {
        Random random = new Random();
        this.uniqueInstance.i = random.nextInt();
    }

    public static synchronized Singleton_Optimized getUniqueInstance() {
        //Check for an instance and if there isn’t one, enter a synchronized block.
        if (uniqueInstance == null) {
            //Note we only synchronize the first time through!
            synchronized (Singleton.class) {
                //Once in the block, check again and if still null, create an instance.
                uniqueInstance = new Singleton_Optimized();
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getUniqueInstance().getValue());
        System.out.println(Singleton.getUniqueInstance().getValue());
        System.out.println(Singleton.getUniqueInstance().getValue());
        System.out.println(Singleton.getUniqueInstance().getValue());
        System.out.println(Singleton.getUniqueInstance().getValue());


    }
}

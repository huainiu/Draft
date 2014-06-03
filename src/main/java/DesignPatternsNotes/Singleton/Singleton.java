package DesignPatternsNotes.Singleton;

import java.util.Random;

/**
 * Created by Michael.Shreiber on 2/19/14.
 */
public class Singleton {
    private static int i;
    private static Singleton uniqueInstance;

    public int getValue(){
        return i;
    }

    private Singleton(){
        Random random = new Random();
        this.uniqueInstance.i = random.nextInt();
    }

    //By adding the synchronized keyword to getInstance(), we force every thread to wait its turn before it can enter the method.
    //That is, no two threads may enter the method at the same time.
    public static synchronized Singleton getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
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

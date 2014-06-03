package Concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Michael.Shreiber on 4/28/14.
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {
        return i.get();
    }

    private void evenIncrement() {
        i.addAndGet(2);
    }

    public void run() {
        while (true)
            evenIncrement();
    }


    /*It should be emphasized that the Atomic classes were designed to build the classes in
    java.util.concurrent, and that you should use them in your own code only under special
    circumstances, and even then only when you can ensure that there are no other possible
    problems. It’s generally safer to rely on locks (either the synchronized keyword or explicit
    Lock objects).*/
    public static void main(String[] args) {

        //Here we’ve eliminated the synchronized keyword by using AtomicInteger instead.
        //Because the program doesn’t fail, a Timer is added to automatically abort after 5 seconds.
        new Timer().schedule(new TimerTask() {
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000); // Terminate after 5 seconds
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while (true) {
            int val = ait.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }

    }
}
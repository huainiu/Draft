package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Michael.Shreiber on 4/26/14.
 */
public class BasicThreadsRunnable {

    public class LiftOff implements Runnable {
        protected int countDown = 10; // Default
        private int taskCount = 0;
        private final int id = taskCount++;

        public LiftOff() {
        }

        public LiftOff(int countDown) {
            this.countDown = countDown;
        }

        public String status() {
            return "#" + id + "(" +
                    (countDown > 0 ? countDown : "Liftoff!") + "), ";
        }

        public void run() {
            while (countDown-- > 0) {
                System.out.print(status());
                Thread.yield();
            }
        }
    }

    public class SleepingTask extends LiftOff {
        public void run() {
            try {
                while (countDown-- > 0) {
                    System.out.print(status());
                    // Old-style:
                    // Thread.sleep(100);
                    // Java SE5/6-style:
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        }
    }


    /*The priority of a thread conveys the importance of a thread to the scheduler. Although the
    order in which the CPU runs a set of threads is indeterminate, the scheduler will lean toward
    running the waiting thread with the highest priority first. However, this doesn’t mean that
    threads with lower priority aren’t run (so you can’t get deadlocked because of priorities).
    Lower-priority threads just tend to run less often.*/
    public class SimplePriorities implements Runnable {
        private int countDown = 5;
        private volatile double d; // No optimization
        private int priority;

        public SimplePriorities(int priority) {
            this.priority = priority;
        }

        public String toString() {
            return Thread.currentThread() + ": " + countDown;
        }

        public void run() {
            Thread.currentThread().setPriority(priority);
            while (true) {
                // An expensive, interruptable operation:
                for (int i = 1; i < 100000; i++) {
                    d += (Math.PI + Math.E) / (double) i;
                    if (i % 1000 == 0)
                        Thread.yield();
                }
                System.out.println(this);
                if (--countDown == 0) return;
            }
        }
    }

    public void testOneThread() {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }

    public void testMorethreads() {
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }

    public void testExecutors() {
        //Testing different type of executors. They can be changed by static method of Executor factory.
        //ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }

    public void testSleeping() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }

    public void testPriority() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(
                    new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(
                new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }

    public static void main(String[] args) {
        BasicThreadsRunnable threads = new BasicThreadsRunnable();
        //threads.testOneThread();
        //threads.testMorethreads();
        //threads.testExecutors();
        //threads.testSleeping();
        threads.testPriority();


    }

}

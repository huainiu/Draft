package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Michael.Shreiber on 4/28/14.
 */
public class SharingResources {


    public class SynchronizedEvenGenerator {
        private int currentEvenValue = 0;

        public synchronized int next() {
            ++currentEvenValue;
            Thread.yield(); // Cause failure faster
            ++currentEvenValue;
            return currentEvenValue;
        }
    }


    public class MutexEvenGenerator {
        private int currentEvenValue = 0;
        /* A ReentrantLock allows you to try and fail to acquire the lock, so that if someone else
         already has the lock, you can decide to go off and do something else rather than waiting until
         it is free, as you can see in the untimed( ) method.*/
        private Lock lock = new ReentrantLock();

        public int next() {
            lock.lock();
            try {
                ++currentEvenValue;
                Thread.yield(); // Cause failure faster
                ++currentEvenValue;
                return currentEvenValue;
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {

    }
}
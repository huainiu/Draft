package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by Michael.Shreiber on 4/24/14.
 */
public class TimerDemo {
    private Timer taskTimer = new Timer(true);

    void setHTTPClientUpdate(long seconds, HTTPClient client) {
        long millis = TimeUnit.SECONDS.convert(seconds, TimeUnit.SECONDS);
        taskTimer.schedule(client, System.currentTimeMillis(), millis);
    }


    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[100];

        for (int i = 1; i < 100; i++) {
            HTTPClient client = new HTTPClient(i);
            Thread  thread = new Thread(client);
            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < threads.length; i++){
            threads[i].join();
        }



    }


}

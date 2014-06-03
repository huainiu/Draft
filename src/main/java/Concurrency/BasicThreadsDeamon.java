package Concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Michael.Shreiber on 4/27/14.
 */
public class BasicThreadsDeamon {

    class ADaemon implements Runnable {
        public void run() {
            try {
                System.out.println("Starting ADaemon");
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {
                System.out.println("Exiting via InterruptedException");
            } finally {
                System.out.println("This should always run?");
            }
        }
    }

    /*When you run this program, you’ll see that the finally clause is not executed, but if you
    comment out the call to setDaemon( ), you’ll see that the finally clause is executed.
    This behavior is correct, even if you don’t expect it based on the previous promises given for
    finally.

    Daemons are terminated "abruptly" when the last of the non-daemons terminates.
    So as soon as main( ) exits, the JVM shuts down all the daemons immediately, without any
    of the formalities you might have come to expect. Because you cannot shut daemons down in
    a nice fashion, they are rarely a good idea. Non-daemon Executors are generally a better
    approach, since all the tasks controlled by an Executor can be shut down at once. As you
    shall see later in the chapter, shutdown in this case proceeds in an orderly fashion.
    Tinking in Java, p. 814*/
    public void testDeamonFinally(){
        Thread t = new Thread(new ADaemon());
        //if you comment out the call to setDaemon( ), you’ll see that the finally clause is executed.
        t.setDaemon(true);
        t.start();
    }

    public static void main(String[] args) {

        BasicThreadsDeamon deamon = new BasicThreadsDeamon();
        deamon.testDeamonFinally();

    }



}

package Concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * A Runnable is a separate task that performs work, but it doesn’t return a value. If you want
 * the task to produce a value when it’s done, you can implement the Callable interface rather
 * than the Runnable interface. Callable, introduced in Java SE5, is a generic with a type
 * parameter representing the return value from the method call( ) (instead of run( )), and
 * must be invoked using an ExecutorService submit( ) method. Here’s a simple example:
 * Created by Michael.Shreiber on 4/26/14.
 */
public class BasicThreadsCallable {

    class TaskWithResult implements Callable<String> {
        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        public String call() {
            return "result of TaskWithResult " + id;
        }
    }


    /*The submit( ) method produces a Future object, parameterized for the particular type of
    result returned by the Callable. You can query the Future with isDone( ) to see if it has
    completed. When the task is completed and has a result, you can call get( ) to fetch the
    result. You can simply call get( ) without checking isDone( ), in which case get( ) will block
    until the result is ready. You can also call get( ) with a timeout, or isDone( ) to see if the
    task has completed, before trying to call get( ) to fetch the result.
    The overloaded Executors.callable( ) method takes a Runnable and produces a
    Callable. ExecutorService has some "invoke" methods that run collections of Callable
    objects.*/
    public void testCalllable() {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results)
            try {
                // get() blocks until completion:
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }


    public static void main(String[] args) {
        BasicThreadsCallable threads = new BasicThreadsCallable();
        threads.testCalllable();

    }


}

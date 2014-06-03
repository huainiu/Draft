/*package JavaCookbook.Log4J;
import org.apache.log4j.Logger;*/

/**
 * Logging using log4j is simple, convenient, and flexible. You need to get a Logger
 * object from the static method Logger.getLogger() , pass in a configuration identifier
 * that can either be a hierarchical name like com.darwinsys or a Class object (e.g.,
 * MyApp.class ) that generates the full package and class name. This name can be used
 * in the configuration file to specify the level of detail that you want to see from the
 * logger. The Logger has public void methods— debug() , info() , warn() , error() and
 * fatal() —each of which takes one Object to be logged. As with System.out.println() ,
 * if you pass in anything that is not a String , its toString() method is called. A generic
 * logging method is also included:
 *      code{public void log(Level level, Object message);}
 *
 * -Dlog4j.configuration=file:[Link to file]
 *
 * The Level class is defined in the log4j package. The standard levels are in this order:
 * DEBUG < INFO < WARN < ERROR < FATAL . So debug messages are least important, and
 * fatal are most important. Each Logger has a level associated with it; messages whose
 * level is less than the Logger ’s level are silently discarded.
 *
 *
 * Created by Michael.Shreiber on 2/17/14.
 */
/*public class Log4JDemo {

    public static void main(String[] args) {
        Logger myLogger = Logger.getLogger("com.darwinsys");
        try {
            Object o = new Object();
            if (o != null) { // bogus, just to show logging
                throw new IllegalArgumentException("Just testing");
            }
            myLogger.info("I created an object: " + o);
        } catch (Exception ex) {
            myLogger.debug("Caught Exception: " + ex);
            myLogger.warn("Caught Exception: " + ex);
            myLogger.error("Caught Exception: " + ex);
            myLogger.fatal("Caught Exception: " + ex);
        }
    }
}*/

package Reflection;

import java.lang.reflect.*;

/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 11/13/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */


public class Apply {

    public static <T, S extends Iterable<? extends T>>

    void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq)
                f.invoke(t, args);
        } catch (Exception e) {
            // Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}
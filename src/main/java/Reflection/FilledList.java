package Reflection;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 11/13/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class FilledList<T> extends ArrayList<T> {

    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++)
                // Assumes default constructor:
                add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package DesignPatternsNotes.Adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by Michael.Shreiber on 2/28/14.
 */
public class EnumerationIterator implements Iterator{
    Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }
    public Object next() {
        return enumeration.nextElement();
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

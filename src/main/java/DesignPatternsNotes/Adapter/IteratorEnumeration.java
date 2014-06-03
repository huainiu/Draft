package DesignPatternsNotes.Adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by Michael.Shreiber on 2/28/14.
 */
public class IteratorEnumeration implements Enumeration {

    private final Iterator iterator;

    public IteratorEnumeration(Iterator iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return this.iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return this.iterator.next();
    }
}

package DesignPatternsNotes.Adapter;

import java.util.*;

/**
 * Created by Michael.Shreiber on 2/28/14.
 */
public class TestAdapters {

    public static void main(String[] args) {
        //Using adapter to get an Iterator Vector
        Vector<String> vector = new Vector<String>();
        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector.add("d");
        vector.add("e");
        Iterator it = new EnumerationIterator(vector.elements());
        while (it.hasNext()){
            System.out.println(it.next());
        }


        //Using adapter to get Enumeration on ArrayList
        List<String> arr = new ArrayList<String>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        Enumeration<String> e = new IteratorEnumeration(arr.iterator());
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }




    }
}

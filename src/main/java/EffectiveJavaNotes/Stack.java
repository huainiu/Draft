package EffectiveJavaNotes;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Michael.Shreiber on 12/16/13.
 *
 * null out references once they become obsolete. In the case of our Stack class,
 * the reference to an item becomes obsolete as soon as it’s popped off the stack.
 * The corrected version of the pop method looks like this:
 *
 * Nulling out object references should be the exception rather than the norm.
 * The best way to eliminate an obsolete reference is to let the variable that contained
 * the reference fall out of scope. This occurs naturally if you define each variable in
 * the narrowest possible scope.
 *
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
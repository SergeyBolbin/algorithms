package com.sbolbin.algorithms.structures;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int n;
    private Object[] items;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        items = new Object[capacity];
    }

    @Override
    public T pop() {
        @SuppressWarnings("unchecked")
        T res = (T) items[--n];
        items[n] = null;
        if (n > 0 && n == items.length / 4) resize(items.length / 2);
        return res;
    }

    @Override
    public void push(T item) {
        items[n++] = item;
        if (n == items.length) resize(items.length * 2);
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int newSize) {
        System.out.println("Resize to " + newSize);
        items = Arrays.copyOf(items, newSize);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = n;

            @Override
            public boolean hasNext() {
                return currentIndex > 0;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) items[--currentIndex];
            }
        };
    }
}

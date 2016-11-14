package com.sbolbin.algorithms.structures;

import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int end;
    private int start;
    private Object[] items;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        items = new Object[capacity];
    }

    @Override
    public T dequeue() {
        @SuppressWarnings("unchecked")
        T result = (T) items[start];
        items[start++] = null;
        return result;
    }

    @Override
    public void enqueue(T item) {
        resizeIfNeeded();
        items[end++] = item;
    }

    @Override
    public boolean isEmpty() {
        return start >= items.length || items[start] == null;
    }

    private void resizeIfNeeded() {
        int lastElement = items.length - 1;
        if (end == lastElement) {
            int newSize = items.length * 2;
            System.out.println("Resize to " + newSize);
            items = Arrays.copyOf(items, newSize);
        }
    }
}

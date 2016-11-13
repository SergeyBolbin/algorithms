package com.sbolibn.algorithms.structures;

import java.util.Arrays;

public class ArrayStack implements Stack {

    private static final int DEFAULT_CAPACITY = 10;

    private int n;
    private String[] items;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        items = new String[capacity];
    }

    @Override
    public String pop() {
        String res = items[--n];
        items[n] = null;
        if(n > 0 && n == items.length / 4) resize(items.length / 2);
        return res;
    }

    @Override
    public void push(String item) {
        items[n++] = item;
        if(n == items.length) resize(items.length * 2);
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int newSize) {
        System.out.println("Resize to " + newSize);
        items = Arrays.copyOf(items, newSize);
    }
}

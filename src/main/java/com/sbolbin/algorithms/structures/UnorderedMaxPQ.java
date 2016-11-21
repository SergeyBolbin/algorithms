package com.sbolbin.algorithms.structures;


import static com.sbolbin.algorithms.utils.Utils.exchange;
import static com.sbolbin.algorithms.utils.Utils.less;

public class UnorderedMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {

    private static final int DEFAULT_CAPACITY = 100;

    private Key[] items;
    private int size;

    public UnorderedMaxPQ() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public UnorderedMaxPQ(int capacity) {
        items = (Key[]) new Comparable[capacity];
    }

    public UnorderedMaxPQ(Key[] arr) {
        items = arr;
        size = arr.length;
    }

    @Override
    public Key delMax() {
        if(isEmpty()) return null;
        int maxIndex = getMaxIndex();
        exchange(items, size - 1, maxIndex);
        return items[--size];
    }

    @Override
    public Key getMax() {
        return !isEmpty() ? items[getMaxIndex()] : null;
    }

    private int getMaxIndex() {
        int max = 0;
        for(int i = 1; i < size; i++) {
            if (less(items[max], items[i])) {
                max = i;
            }
        }

        return max;
    }

    @Override
    public void insert(Key item) {
        items[size++] = item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}

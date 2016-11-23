package com.sbolbin.algorithms.structures;

import java.util.Arrays;

import static com.sbolbin.algorithms.utils.Utils.insertAtPosition;

public class ArraySymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private static final int DEFAULT_CAPACITY = 1000;

    private Key[] keys;
    private Value[] values;
    private int size;

    public ArraySymbolTable() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArraySymbolTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        if (isEmpty()) {
            keys[size] = key;
            values[size++] = value;
            return;
        }

        int rank = getRank(key);
        if (sameKeyExists(key, rank)) {
            values[rank] = value;
        } else {
            insertAtPosition(keys, rank, size, key);
            insertAtPosition(values, rank, size, value);
            size++;
        }

    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;

        int rank = getRank(key);
        if (sameKeyExists(key, rank)) {
            return values[rank];
        } else {
            return null;
        }
    }

    private boolean sameKeyExists(Key key, int position) {
        return position < size && keys[position].compareTo(key) == 0;
    }

    private int getRank(Key key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }

        return lo;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return Arrays.asList(Arrays.copyOf(keys, size));
    }
    
}

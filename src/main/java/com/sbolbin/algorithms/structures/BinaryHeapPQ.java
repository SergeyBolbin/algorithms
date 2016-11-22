package com.sbolbin.algorithms.structures;

import static com.sbolbin.algorithms.utils.Utils.exchange;
import static com.sbolbin.algorithms.utils.Utils.less;

public class BinaryHeapPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {

    private static final int DEFAULT_CAPACITY = 101;

    private int size;
    private Key[] items;

    public BinaryHeapPQ() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public BinaryHeapPQ(int capacity) {
        items = (Key[]) new Comparable[capacity];
    }

    @Override
    public Key delMax() {
        Key max = items[1];
        exchange(items, 1, size--);
        sink(1);
        items[size + 1] = null;
        return max;
    }

    @Override
    public Key getMax() {
        return items[1];
    }

    @Override
    public void insert(Key item) {
        items[++size] = item;
        swim(size);
    }

    /**
     * Prevent violation: children key is greater, then it's parent
     * @param position pos
     */
    private void swim(int position) {
        while (position > 1 && less(items[position / 2], items[position])) {
            exchange(items, position / 2, position);
            position /= 2;
        }
    }

    /**
     * Prevent violation: Parent key becomes smaller, then one or both of children
     * @param k pos
     */
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(items[j], items[j + 1])) j++; //neighbour, left/right children of pos
            if (!less(items[k], items[j])) break; //already in-place
            exchange(items, j, k);
            k = j;
        }
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

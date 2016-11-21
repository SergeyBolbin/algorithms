package com.sbolbin.algorithms.structures;

public interface MaxPQ<Key extends Comparable<Key>> {

    Key delMax();

    Key getMax();

    void insert(Key item);

    boolean isEmpty();

    int size();

}

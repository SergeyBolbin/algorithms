package com.sbolbin.algorithms.structures;

public interface Queue<T> extends Iterable<T> {

    T dequeue();

    void enqueue(T item);

    boolean isEmpty();

}

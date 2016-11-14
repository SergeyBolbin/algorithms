package com.sbolbin.algorithms.structures;

public interface Queue<T> {

    T dequeue();

    void enqueue(T item);

    boolean isEmpty();

}

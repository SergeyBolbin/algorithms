package com.sbolbin.algorithms.structures;

public interface Stack<T> extends Iterable<T> {

    T pop();

    void push(T item);

    boolean isEmpty();

}

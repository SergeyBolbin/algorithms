package com.sbolbin.algorithms.structures;

import java.util.Iterator;

public class LinkedStack<T> implements Stack<T> {

    private class Node {
        private T item;
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class ListIterator implements Iterator<T> {

        private Node current;

        public ListIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T result = current.item;
            current = current.next;
            return result;
        }
    }

    private Node head = null;


    public T pop() {
        T value = head.item;
        head = head.next;
        return value;
    }

    public void push(T item) {
        head = new Node(item, head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }
}

package com.sbolbin.algorithms.structures;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {

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

        ListIterator(Node current) {
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

    private Node head;
    private Node tail;

    @Override
    public T dequeue() {
        T value = head.item;
        head = head.next;
        return value;
    }

    @Override
    public void enqueue(T item) {
        Node newTail = new Node(item, null);
        if (head == null) {
            head = tail = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }
}

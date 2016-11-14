package com.sbolbin.algorithms.structures;

public class LinkedQueue<T> implements Queue<T> {

    private class Node {
        private T item;
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
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
}

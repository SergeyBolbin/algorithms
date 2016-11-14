package com.sbolbin.algorithms.structures;

public class LinkedStack<T> implements Stack<T> {

    private class Node {
        private T item;
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
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
}

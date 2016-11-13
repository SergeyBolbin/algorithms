package com.sbolbin.algorithms.structures;

public class LinkedQueue implements Queue {

    private class Node {
        private String item;
        private Node next;

        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    @Override
    public String dequeue() {
        String value = head.item;
        head = head.next;
        return value;
    }

    @Override
    public void enqueue(String item) {
        Node newTail = new Node(item, null);
        if(head == null) {
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

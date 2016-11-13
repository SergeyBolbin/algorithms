package com.sbolibn.algorithms.structures;

public class LinkedStack implements Stack {

    private class Node {
        private String item;
        private Node next;

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head = null;


    public String pop() {
        String value = head.item;
        head = head.next;
        return value;
    }

    public void push(String item) {
        head = new Node(item, head);
    }

    public boolean isEmpty() {
        return head == null;
    }
}

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

    private Node root = null;


    public String pop() {
        String value = root.item;
        root = root.next;
        return value;
    }

    public void push(String item) {
        root = new Node(item, root);
    }

    public boolean isEmpty() {
        return root == null;
    }
}

package com.sbolbin.algorithms.structures;

public class BST<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private class Node {

        private Key key;
        private Value value;
        private int size;

        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) node = new Node(key, value);

        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            node.right = put(node.right, key, value);
        } else if (cmp > 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        node.size = size(node.left) + 1 + size(node.right);
        return node;
    }

    @Override
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = node.key.compareTo(key);
            if (cmp < 0) node = node.right;
            else if (cmp > 0) node = node.left;
            else return node.value;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedQueue<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node node, Queue<Key> queue) {
        if (node == null) return;
        inorder(node.left, queue);
        queue.enqueue(node.key);
        inorder(node.right, queue);
    }
}

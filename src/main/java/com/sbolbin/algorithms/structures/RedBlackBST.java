package com.sbolbin.algorithms.structures;

public class RedBlackBST<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {

        private Key key;
        private Value value;
        private int size;
        private boolean color;

        private Node left, right;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
    private Node root;

    /**
     * Balance modifications rules:
     *
     * ・Right child red, left child black: rotate left.
     * ・Left child, left-left grandchild red: rotate right.
     * ・Both children red: flip colors.
     */
    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) node = new Node(key, value, RED);

        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            node.right = put(node.right, key, value);
        } else if (cmp > 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        updateSize(node);
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
    public void delete(Key key) {
        root = delete(root, key);
    }

    //Hibbard deletion impl
    private Node delete(Node parent, Key key) {
        if (parent == null) return null;
        int cmp = key.compareTo(parent.key);

        if (cmp > 0) {
            parent.right = delete(parent.right, key);
        } else if (cmp < 0) {
            parent.left = delete(parent.left, key);
        } else {
            if (parent.left == null) return parent.right;
            if (parent.right == null) return parent.left;

            Node t = parent;
            parent = min(t.right); // min from right children
            parent.left = t.left;  // restore left subtree as-is
            parent.right = deleteMin(t.right);  // remove min from right sub-tree (transfer to the top)
        }

        updateSize(parent);
        return parent;
    }

    private void updateSize(Node node) {
        node.size = size(node.left) + 1 + size(node.right);
    }

    private Node min(Node node) {
        Node t = node;
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        updateSize(x);
        return x;
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

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private Node rotateLeft(Node h) {
        assert(isRed(h.right));
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        updateSize(h);
        return x;
    }

    private Node rotateRight(Node h) {
        assert(isRed(h.left));
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        updateSize(h);
        return x;
    }

    private void flipColors(Node h) {
        assert(isRed(h.left));
        assert(isRed(h.right));
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}

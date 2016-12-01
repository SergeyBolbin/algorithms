package com.sbolbin.algorithms.structures;

public class SeparateChainingHashTable<Key, Value> implements HashTable<Key, Value> {

    private static final int NUM_OF_CHAINS = 97;

    private Node[] table;

    private static class Node {
        Object key;
        Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SeparateChainingHashTable() {
        table = new Node[NUM_OF_CHAINS];
    }


    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % NUM_OF_CHAINS;
    }

    @Override
    public void put(Key key, Value value) {
        int h = hash(key);
        for (Node x = table[h]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }

        table[h] = new Node(key, value, table[h]);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        int h = hash(key);
        for (Node x = table[h]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.value;
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Value remove(Key key) {
        int h = hash(key);
        Node prev = null;
        for (Node x = table[h]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                Value result = (Value) x.value;
                if (prev == null) {
                    table[h] = x.next;
                } else {
                    prev.next = x.next;
                }
                return result;
            }

            prev = x;
        }
        return null;
    }
}

package com.sbolbin.algorithms.structures;

import static com.sbolbin.algorithms.utils.Utils.shiftToTheLeft;

public class LinearProbingHashTable<Key, Value> implements HashTable<Key, Value> {

    private static final int M = 3000;

    @SuppressWarnings("unchecked")
    private Value[] values = (Value[]) new Object[M];

    @SuppressWarnings("unchecked")
    private Key[] keys = (Key[]) new Object[M];


    @Override
    public void put(Key key, Value value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                break;
            }
        }
        keys[i] = key;
        values[i] = value;
    }

    @Override
    public Value get(Key key) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }

        return null;
    }

    @Override
    public Value remove(Key key) { //TODO: fixme
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                Value v = values[i];
                shiftToTheLeft(keys, i, M);
                shiftToTheLeft(values, i, M);
                return v;
            }
        }

        return null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
}

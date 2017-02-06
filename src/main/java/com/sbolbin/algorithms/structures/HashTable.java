package com.sbolbin.algorithms.structures;


public interface HashTable<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    Value remove(Key key);
}

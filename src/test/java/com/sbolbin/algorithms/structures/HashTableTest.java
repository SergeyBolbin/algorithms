package com.sbolbin.algorithms.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashTableTest {

    @Test
    public void testChainedHT() {
        testHT(new SeparateChainingHashTable<>(), 100);
    }

    @Test
    public void testLinearProbe() {
        testHT(new LinearProbingHashTable<>(), 3);
    }

    private void testHT(HashTable<Integer, String> table, int size) {
        for (int i = 0; i < size; i++) {
            String st = String.valueOf(i);
            table.put(i, st);
            assertEquals(st, table.get(i));
        }

        for (int i = 0; i < size; i++) {
            String s = table.remove(i);
            assertEquals(String.valueOf(i), s);
            assertNull(table.get(i));
        }
    }
}

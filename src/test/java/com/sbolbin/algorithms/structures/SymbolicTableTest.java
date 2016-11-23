package com.sbolbin.algorithms.structures;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SymbolicTableTest {

    @Test
    public void testArraySymbolTable() {
        testSymbolTable(new ArraySymbolTable<>());
    }

    private void testSymbolTable(SymbolTable<String, Integer> table) {
        assert table.isEmpty();

        table.put("C", 1);
        table.put("D", 1);
        table.put("A", 1);

        assertEquals(table.size(), 3);
        assertEquals(table.get("A"), Integer.valueOf(1));
        assertEquals(table.get("D"), Integer.valueOf(1));
        assertEquals(table.get("C"), Integer.valueOf(1));

        assert table.contains("A");
        assert table.contains("C");
        assert table.contains("D");
        assert !table.contains("B");

        table.put("B", 1);
        table.put("C", 2);

        assertEquals(table.size(), 4);
        assertEquals(table.get("A"), Integer.valueOf(1));
        assertEquals(table.get("B"), Integer.valueOf(1));
        assertEquals(table.get("C"), Integer.valueOf(2));
        assertEquals(table.get("D"), Integer.valueOf(1));

        assertEquals(table.keys(), Arrays.asList("A", "B", "C", "D"));

    }
}

package com.sbolbin.algorithms.structures;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SymbolTableTest {

    @Test
    public void testArraySymbolTable() {
        testSymbolTable(new ArraySymbolTable<>());
    }

    @Test
    public void testBST() {
        testSymbolTable(new BST<>());
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

        String[] expectedArr = {"A", "B", "C", "D"};
        String[] actualArr = new String[table.size()];
        int i = 0;
        for (String k : table.keys()) {
            actualArr[i++] = k;
        }

        assertArrayEquals(expectedArr, actualArr);

        table.delete("B");
        assertEquals(3, table.size());
        assert table.contains("A") && table.contains("C") && table.contains("D") && !table.contains("B");

        table.delete("E");
        assertEquals(3, table.size());
        assert table.contains("A") && table.contains("C") && table.contains("D") && !table.contains("B");

        table.delete("A");
        assertEquals(2, table.size());
        assert !table.contains("A") && table.contains("C") && table.contains("D") && !table.contains("B");

        table.delete("D");
        assertEquals(1, table.size());
        assert !table.contains("A") && table.contains("C") && !table.contains("D") && !table.contains("B");
    }
}

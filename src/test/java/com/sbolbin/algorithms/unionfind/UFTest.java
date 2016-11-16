package com.sbolbin.algorithms.unionfind;

import org.junit.Test;

public class UFTest {

    private int size = 10;

    @Test
    public void testQuickFind() {
        performTest(new UFQuickFind(size));
    }

    @Test
    public void testQuickUnion() {
        performTest(new UFQuickUnion(size));
    }

    @Test
    public void testQuickUnionWeighted() {
        performTest(new UFQuickUnionWeighted(size));
    }

    private void performTest(UF uf) {
        System.out.println();

        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);

        assert uf.connected(8, 9);
        assert !uf.connected(0, 7);
        System.out.println(uf);

        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);

        assert uf.connected(8, 9);
        assert uf.connected(0, 7);
        System.out.println(uf);

        uf.union(7, 8);
        System.out.println(uf);
    }
}

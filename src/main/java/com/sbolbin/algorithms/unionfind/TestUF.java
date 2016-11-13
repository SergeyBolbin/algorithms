package com.sbolbin.algorithms.unionfind;

import java.io.IOException;

public class TestUF {
    public static void main(String[] args) throws IOException {
        int size = 10;

        performTest(new UFQuickFind(size));
        performTest(new UFQuickUnion(size));
        performTest(new UFQuickUnionWeighted(size));
    }

    private static void performTest(UF uf) {
        System.out.println();

        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);

        if (!uf.connected(8, 9)) throw new AssertionError();
        if (uf.connected(0, 7)) throw new AssertionError();
        System.out.println(uf);

        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);

        if (!uf.connected(8, 9)) throw new AssertionError();
        if (!uf.connected(0, 7)) throw new AssertionError();
        System.out.println(uf);

        uf.union(7, 8);
        System.out.println(uf);
    }

}

package com.sbolbin.algorithms.unionfind;

public class UFQuickUnion extends AbstractUF {

    public UFQuickUnion(int size) {
        super(size);
    }

    private int root(int i) {
        while (i != ids[i])
            i = ids[i];
        return i;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        ids[pRoot] = qRoot;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

package com.sbolibn.algorithms.unionfind;

public class UFQuickUnionWeighted extends UFQuickUnion {

    private int[] sz;

    public UFQuickUnionWeighted(int size) {
        super(size);
        sz = new int[size];
        for(int i = 0; i < size; i++)
            sz[i] = 1;
    }

    private int root(int i) {
        while (i != ids[i])
            i = ids[ids[i]];

        return i;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        int pSize = sz[p];
        int qSize = sz[p];

        if(pSize < qSize) {
           ids[pRoot] = qRoot;
           sz[qRoot] += pSize;
        } else {
           ids[qRoot] = pRoot;
           sz[pRoot] += qSize;
        }
    }

}

package com.sbolibn.algorithms.unionfind;

public class UFQuickFind extends AbstractUF {

    public UFQuickFind(int size) {
        super(size);
    }

    public void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];
        for(int i = 0; i < ids.length; i++ ) {
            if(ids[i] == pid) ids[i] = qid;
        }
    }

    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }
}

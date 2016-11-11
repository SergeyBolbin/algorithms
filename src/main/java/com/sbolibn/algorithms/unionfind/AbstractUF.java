package com.sbolibn.algorithms.unionfind;

public abstract class AbstractUF implements UF {

    protected int[] ids;

    public AbstractUF(int size) {
        ids = new int[size];
        for(int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int id : ids) {
            sb.append(id);
            sb.append(" ");
        }
        return sb.toString();
    }
}

package com.sbolbin.algorithms.graphs;

public interface Graph {

    /**
     * Add an edge v-w
     */
    void addEdge(int v, int w);

    /**
     * Return vertices adjacent to v
     */
    Iterable<Integer> adjusted(int v);

    /**
     * Return number of vertices
     */
    int vertices();

}

package com.sbolbin.algorithms.graphs;


import java.util.HashSet;
import java.util.Set;

public abstract class AdjacencyListBasedGraph implements Graph {

    private int vertices;
    private Set<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public AdjacencyListBasedGraph(int vertices) {
        this.vertices = vertices;
        this.adj = (Set<Integer>[]) new Set[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new HashSet<>();
        }
    }

    @Override
    public abstract void addEdge(int v, int w);


    protected Set<Integer>[] getAdjacencyList() {
        return adj;
    }

    @Override
    public Iterable<Integer> adjusted(int v) {
        return adj[v];
    }

    @Override
    public int vertices() {
        return vertices;
    }
}

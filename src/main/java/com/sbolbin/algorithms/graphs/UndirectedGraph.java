package com.sbolbin.algorithms.graphs;

public class UndirectedGraph extends AdjacencyListBasedGraph {

    public UndirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int v, int w) {
        getAdjacencyList()[v].add(w);
        getAdjacencyList()[w].add(v);
    }
}

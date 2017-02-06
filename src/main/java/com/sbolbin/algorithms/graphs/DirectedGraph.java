package com.sbolbin.algorithms.graphs;

public class DirectedGraph extends AdjacencyListBasedGraph {

    public DirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int v, int w) {
        getAdjacencyList()[v].add(w);
    }
}

package com.sbolbin.algorithms.graphs.app;

import com.sbolbin.algorithms.graphs.Graph;
import com.sbolbin.algorithms.structures.LinkedStack;
import com.sbolbin.algorithms.structures.Stack;

public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int sourceVertex;

    public DepthFirstPaths(Graph graph, int sourceVertex) {
        this.sourceVertex = sourceVertex;
        int size = graph.vertices();
        marked = new boolean[size];
        edgeTo = new int[size];

        dfs(graph, sourceVertex);
    }

    private void dfs(Graph g, int vertex) {
        marked[vertex] = true;
        for (int w : g.adjusted(vertex)) {
            if (!marked[w]) {
                dfs (g, w);
                edgeTo[w] = vertex;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo (int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new LinkedStack<>();
        for (int x = v; x != sourceVertex; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(sourceVertex);
        return path;
    }

}

package com.sbolbin.algorithms.graphs.app;

import com.sbolbin.algorithms.graphs.Graph;
import com.sbolbin.algorithms.structures.LinkedQueue;
import com.sbolbin.algorithms.structures.LinkedStack;
import com.sbolbin.algorithms.structures.Queue;
import com.sbolbin.algorithms.structures.Stack;

public class BreadthFirstSearchPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int sourceVertex;

    public BreadthFirstSearchPaths(Graph graph, int sourceVertex) {
        int size = graph.vertices();
        marked = new boolean[size];
        edgeTo = new int[size];
        distTo = new int[size];
        this.sourceVertex = sourceVertex;

        bfs(graph, sourceVertex);
    }

    private void bfs(Graph graph, int vertex) {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(vertex);
        marked[vertex] = true;
        distTo[vertex] = 0;

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : graph.adjusted(v)) {
                if (! marked[w]) {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo (int v) {
        if(!hasPathTo(v)) return null;

        Stack<Integer> path = new LinkedStack<>();
        for (int x = v; x != sourceVertex; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(sourceVertex);
        return path;
    }

    public int distTo (int v) {
        if (!hasPathTo(v)) return -1;
        return distTo[v];
    }
}


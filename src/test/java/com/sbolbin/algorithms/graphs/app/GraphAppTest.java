package com.sbolbin.algorithms.graphs.app;

import com.sbolbin.algorithms.graphs.Graph;
import com.sbolbin.algorithms.graphs.UndirectedGraph;
import org.junit.Test;


public class GraphAppTest {

    private final Graph udGraph = createUDGraph();

    @Test
    public void testDFS() {
        DepthFirstPaths dfs = new DepthFirstPaths(udGraph, 0);
        for (int i = 0; i < udGraph.vertices(); i++) {
            assert dfs.hasPathTo(i);
            System.out.println("Vertex " + i + ": " + getPathAsString(dfs.pathTo(i)));
        }
    }

    @Test
    public void testBFS() {
        BreadthFirstSearchPaths bfs = new BreadthFirstSearchPaths(udGraph, 0);
        for (int i = 0; i < udGraph.vertices(); i++) {
            assert bfs.hasPathTo(i);
            System.out.println("Vertex " + i + ": " + getPathAsString(bfs.pathTo(i)) + "; distance=" + bfs.distTo(i));
        }
    }


    private Graph createUDGraph() {
        Graph graph = new UndirectedGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);

        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        return graph;
    }

    private String getPathAsString(Iterable<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (Integer s : path) {
            sb.append(s);
            sb.append(' ');
        }

        return sb.toString().trim();
    }

}

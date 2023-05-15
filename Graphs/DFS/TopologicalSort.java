package Graphs.DFS;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    static class Edge {
        int source;
        int neighbour;

        Edge(int source, int neighbour) {
            this.source = source;
            this.neighbour = neighbour;
        }
    }


    // Topological Sort - A permutation for vertices for a directed cyclic graph is called topological sort if for all directed edges
    //                    uv, u appears before v in the graph

    // When to use Topological Sort:
    // 1. Finding cycle in a graph
    // 2. Operating System deadlock detection
    // 3. Dependency resolution (when work 1 is dependent on work 2, then work 2 has to be done first)
    // 4. Sentence Ordering
    // 5. Critical Path Analysis
    // 6. Course Schedule problem
    // 7. Other applications like manufacturing workflows, data serialization and context-free grammar

    static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int source, boolean[] visited, Stack<Integer> st) {
        visited[source] = true;
        for (Edge e : graph.get(source)) {
            if (!visited[e.neighbour]) {
                topologicalSort(graph, e.neighbour, visited, st);
            }
        }
        st.push(source);
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // vertices
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Edges
        // Directed
        graph.get(0).add(new Edge(0, 1));
        graph.get(1).add(new Edge(1, 2));
        graph.get(2).add(new Edge(2, 3));
        graph.get(0).add(new Edge(0, 3));
        graph.get(4).add(new Edge(4, 3));
        graph.get(4).add(new Edge(4, 5));
        graph.get(5).add(new Edge(5, 6));
        graph.get(4).add(new Edge(4, 6));


        // Topological Sort
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }

    }

}

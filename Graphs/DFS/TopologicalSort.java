package Graphs.DFS;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    // Topological Sort - Topological sort is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order.
    // Topological sorting is used only for DAGs(Directed Acyclic Graphs), (not for non-DAGs)

    static class Edge {
        int source, destination;

        Edge(int source, int neighbour) {
            this.source = source;
            this.destination = neighbour;
        }
    }

    static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static void topologicalSortUtil(ArrayList<ArrayList<Edge>> graph, int source, boolean[] visited, Stack<Integer> st) {
        visited[source] = true;
        for (Edge e : graph.get(source)) {
            if (!visited[e.destination]) {
                topologicalSortUtil(graph, e.destination, visited, st);
            }
        }
        st.push(source);
    }


    // without Edge
    static void topologicalSort2(ArrayList<ArrayList<Integer>> graph, int vertices) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil2(graph, i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void topologicalSortUtil2(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (Integer i : graph.get(vertex)) {
            if (!visited[i]) {
                topologicalSortUtil2(graph, i, visited, stack);
            }
        }
        stack.push(vertex);
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 3));

        graph.get(1).add(new Edge(1, 2));

        graph.get(2).add(new Edge(2, 3));

        graph.get(4).add(new Edge(4, 3));
        graph.get(4).add(new Edge(4, 5));
        graph.get(4).add(new Edge(4, 6));

        graph.get(5).add(new Edge(5, 6));

        topologicalSort(graph, vertices);


        // without Edge
//        int vertices = 7;
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
//        for (int i = 0; i < vertices; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        graph.get(0).add(1);
//        graph.get(0).add(3);
//
//        graph.get(1).add(2);
//
//        graph.get(2).add(3);
//
//        graph.get(4).add(3);
//        graph.get(4).add(5);
//        graph.get(4).add(6);
//
//        graph.get(5).add(6);
//
//        topologicalSort2(graph, vertices);

    }

}

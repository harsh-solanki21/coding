package Graphs.Algorithms.DFS;

import java.util.ArrayList;
import java.util.Stack;

public class DFSList {

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }


    // Iterative DFS Using Stack
    // It iterates in reverse in the euler path
    static void DFS(ArrayList<ArrayList<Edge>> graph, int source, boolean[] visited) {
        Stack<Integer> st = new Stack<>();
        st.push(source);

        while (!st.empty()) {
            source = st.pop();

            if (visited[source]) {
                continue;
            }
            visited[source] = true;
            System.out.print(source + " ");

            for (Edge edge : graph.get(source)) {
                if (!visited[edge.dest]) {
                    st.add(edge.dest);
                }
            }

        }
    }


    // Recursive Solution
    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> ans) {
        visited[node] = true;
        ans.add(node);

        for (Integer i : graph.get(node)) {
            if (!visited[i]) {
                dfs(i, visited, graph, ans);
            }
        }
    }

    static ArrayList<Integer> dfsTraversal(int vertices, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[vertices + 1];
        visited[0] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, visited, graph, ans);
        return ans;
    }


    public static void main(String[] args) {
//        int vertices = 7;
//        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
//
//        // vertices
//        for (int i = 0; i < vertices; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        // edges
//        graph.get(0).add(new Edge(0, 1));
//        graph.get(1).add(new Edge(1, 2));
//        graph.get(2).add(new Edge(2, 3));
//        graph.get(0).add(new Edge(0, 3));
//        graph.get(3).add(new Edge(3, 4));
//        graph.get(4).add(new Edge(4, 5));
//        graph.get(5).add(new Edge(5, 6));
//        graph.get(4).add(new Edge(4, 6));
//
//        // also need to add this because of undirected graph
//        graph.get(1).add(new Edge(1, 0));
//        graph.get(2).add(new Edge(2, 1));
//        graph.get(3).add(new Edge(3, 2));
//        graph.get(3).add(new Edge(3, 0));
//        graph.get(4).add(new Edge(4, 3));
//        graph.get(5).add(new Edge(5, 4));
//        graph.get(6).add(new Edge(6, 5));
//        graph.get(6).add(new Edge(6, 4));
//
//
//        // Iterative
//        boolean[] visited = new boolean[vertices];
//        int source = 0;
//        DFS(graph, source, visited);


        // Recursive
        // Time Complexity: For an undirected graph, O(V) + O(2E), For a directed graph, O(V + E),
        // Because for every node we are calling the recursive function once,
        // the time taken is O(V) and 2E is for total degrees as we traverse for all adjacent nodes.

        // Space Complexity: O(3V) = O(V), Space for dfs stack space, visited array and an adjacency list.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(2);
        graph.get(2).add(0);
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(3);
        graph.get(3).add(0);
        graph.get(2).add(4);
        graph.get(4).add(2);

        System.out.print(dfsTraversal(5, graph));

    }

}

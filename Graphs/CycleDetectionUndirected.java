package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class CycleDetectionUndirected {

    // DFS
    static boolean detectCycle(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src, int parent) {
        visited[src] = true;
        for (int i : graph.get(src)) {
            if (!visited[i]) {
                if (dfs(graph, visited, i, src)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }


    // BFS
    static class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices + 1];  // +1 because of 1 based indexing
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                if (checkCycle(graph, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src) {
        visited[src] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();

            for (int i : graph.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new Pair(i, node));
                } else if (parent != i) {
                    return true;
                }
            }
        }

        return false;
    }


    // DSU
    static boolean isCycleDSU(ArrayList<ArrayList<Integer>> graph, int vertices) {
        int[] parent = new int[vertices + 1];

        for (int i = 0; i <= vertices; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < vertices; i++) {
            for (int j : graph.get(i)) {
                if (i < j) {
                    int x = findRoot(parent, i);
                    int y = findRoot(parent, j);
                    if (x == y) {
                        return true;
                    }
                    parent[y] = x;
                }
            }
        }

        return false;
    }

    private static int findRoot(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 5);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 6);  // cycle edge
        addEdge(graph, 5, 7);
        addEdge(graph, 6, 7);

        // BFS
        System.out.println(isCycle(graph, vertices));

        // DFS
        System.out.println(detectCycle(graph, vertices));

        // DSU
        System.out.println(isCycleDSU(graph, vertices));

    }

}

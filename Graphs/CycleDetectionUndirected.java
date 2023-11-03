package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
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


    // DSU (Disjoint Set Union) (Union-Find Algorithm)
    static class Edge {
        int source, destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(5);

        graph.get(3).add(1);
        graph.get(3).add(4);
//        graph.get(3).add(6);

        graph.get(4).add(3);

        graph.get(5).add(2);
        graph.get(5).add(7);

//        graph.get(6).add(3);
        graph.get(6).add(7);

        graph.get(7).add(5);
        graph.get(7).add(6);

        // BFS
//        System.out.println(isCycle(graph, vertices));

        // DFS
        System.out.println(detectCycle(graph, vertices));

        // DSU
        System.out.println(isCycle(graph, vertices));

    }

}

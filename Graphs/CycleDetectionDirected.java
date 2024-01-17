package Graphs;

import java.util.ArrayList;

public class CycleDetectionDirected {

    // Ways to detect cycle in Directed Graph
    // DFS, BFS, Topological Sorting (Kahn's Algorithm), Graph Coloring


    // DFS
    static boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices + 1];
        boolean[] path = new boolean[vertices + 1];

        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, path, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] path, int node) {
        visited[node] = true;
        path[node] = true;
        for (int i : graph.get(node)) {
            if (!visited[i]) {
                if (dfs(graph, visited, path, i)) {
                    return true;
                }
            } else if (path[i]) {
                return true;
            }
        }
        path[node] = false;
        return false;
    }


    public static void main(String[] args) {
        int vertices = 8;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);

        graph.get(2).add(3);
        graph.get(2).add(4);

        graph.get(3).add(7);
        graph.get(3).add(8);

        graph.get(4).add(5);

        graph.get(5).add(6);

        graph.get(6).add(4);

        graph.get(8).add(7);

        System.out.println(isCyclic(graph, vertices));

    }

}

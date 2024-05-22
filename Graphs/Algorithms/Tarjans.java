package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tarjans {

    // Bridge is an edge whose deletion increases the graph's number of connected components.
    // Usually for Undirected Graph

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static List<List<Integer>> getBridge(ArrayList<Edge>[] graph, int vertices) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] dt = new int[vertices + 1];  // discovery time
        int[] low = new int[vertices + 1];  // lowest discovery time
        boolean[] visited = new boolean[vertices + 1];
        int time = 0;

        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                dfs(graph, visited, dt, low, time, -1, i, ans);
            }
        }

        return ans;
    }

    private static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int[] dt, int[] low, int time, int parent, int node, List<List<Integer>> ans) {
        visited[node] = true;
        dt[node] = low[node] = ++time;

        for (Edge e : graph[node]) {
            if (e.dest == parent) {
                continue;
            } else if (!visited[e.dest]) {
                dfs(graph, visited, dt, low, time, node, e.dest, ans);
                low[node] = Math.min(low[node], low[e.dest]);
                if (dt[node] < low[e.dest]) {
                    ans.add(Arrays.asList(node, e.dest));
                }
            } else {
                low[node] = Math.min(low[node], dt[e.dest]);
            }
        }

    }


    static void addEdge(ArrayList<Edge>[] graph, int u, int v) {
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }

    public static void main(String[] args) {

//        1 -- 4 -- 5    7            11
//        |    |    |  /   \        /  |
//        2 -- 3     6      8 -- 10    |
//                     \   /        \  |
//                       9            12

        int vertices = 12;
        ArrayList<Edge>[] graph = new ArrayList[vertices + 1];
        for (int i = 0; i <= vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 1, 2);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 7);
        addEdge(graph, 6, 9);
        addEdge(graph, 7, 8);
        addEdge(graph, 8, 9);
        addEdge(graph, 8, 10);
        addEdge(graph, 10, 11);
        addEdge(graph, 10, 12);
        addEdge(graph, 11, 12);

        System.out.println(getBridge(graph, vertices));

    }

}

package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {

    // A vertex in an undirected connected graph is an articulation point (or cut vertex) if removing it (and edges through it) disconnects the graph.


    // Naive Approach:
    // Remove every vertex one-by-one and check if graph disconnects or not using DFS.
    // TC - O(V * (V + E))

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static List<Integer> articulationPointNaive(ArrayList<Edge>[] graph, int vertices) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            int components = 0;
            boolean[] visited = new boolean[vertices];

            for (int j = 0; j < vertices; j++) {
                if (j != i) {
                    if (!visited[j]) {
                        components++;
                        dfs(graph, visited, i, j);
                    }
                }
            }

            if (components > 1) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int i, int curr) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (e.dest != i) {
                if (!visited[e.dest]) {
                    dfs(graph, visited, i, e.dest);
                }
            }
        }
    }


    // Optimized Approach - Tarjan's Algorithm
    // TC - O(V + E)

    static List<Integer> articulationPoint(ArrayList<Edge>[] graph, int vertices) {
        List<Integer> ans = new ArrayList<>();
        int[] dt = new int[vertices + 1];  // discovery time
        int[] low = new int[vertices + 1];  // lowest discovery time
        boolean[] visited = new boolean[vertices + 1];
        boolean[] ap = new boolean[vertices + 1];  // Articulation Point
        int time = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(graph, dt, low, visited, ap, time, -1, i);
            }
        }

        for (int i = 0; i < vertices; i++) {
            if (ap[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static void dfs(ArrayList<Edge>[] graph, int[] dt, int[] low, boolean[] visited, boolean[] ap, int time, int parent, int curr) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (Edge e : graph[curr]) {
            if (parent == e.dest) {
                continue;
            } else if (visited[e.dest]) {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else {
                dfs(graph, dt, low, visited, ap, time, curr, e.dest);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] <= low[e.dest] && parent != -1) {
                    ap[curr] = true;
                }
                children++;
            }
        }

        if (parent == -1 && children > 1) {
            ap[curr] = true;
        }
    }


    static void addEdge(ArrayList<Edge>[] graph, int u, int v) {
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }

    public static void main(String[] args) {

//      1 -- 0 -- 3
//      |  /      |
//      2         4

        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 3, 4);

//        System.out.println(articulationPointNaive(graph, vertices));
        System.out.println(articulationPoint(graph, vertices));

    }

}

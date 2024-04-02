package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tarjans {

    // Bridge is an edge whose deletion increases the graph's number of connected components.

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

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
        graph[6].add(new Edge(6, 7));

        graph[7].add(new Edge(7, 6));
        graph[7].add(new Edge(7, 8));

        graph[8].add(new Edge(8, 7));
        graph[8].add(new Edge(8, 9));
        graph[8].add(new Edge(8, 10));

        graph[9].add(new Edge(9, 6));
        graph[9].add(new Edge(9, 8));

        graph[10].add(new Edge(10, 8));
        graph[10].add(new Edge(10, 11));
        graph[10].add(new Edge(10, 12));

        graph[11].add(new Edge(11, 10));
        graph[11].add(new Edge(11, 12));

        graph[12].add(new Edge(12, 10));
        graph[12].add(new Edge(12, 11));


        System.out.println(getBridge(graph, vertices));

    }

}

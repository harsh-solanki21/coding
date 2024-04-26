package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class ShortestPathInDAG {


    // Using Dijkstra's Algorithm
    static class Pair implements Comparable<Pair> {
        int src, weight;

        Pair(int src, int weight) {
            this.src = src;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair p) {
            return this.weight - p.weight;
        }

    }

    static int[] shortestPathDijkstras(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new Pair(0, 0));
        cost[0] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (Pair p : graph.get(curr.src)) {
                if (curr.weight + p.weight < cost[p.src]) {
                    cost[p.src] = curr.weight + p.weight;
                    pq.offer(new Pair(p.src, cost[p.src]));
                }
            }
        }

        for (int i = 0; i < cost.length; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                cost[i] = -1;
            }
        }

        return cost;
    }


    // Using Topological Sort
    static class Pairs {
        int node, weight;

        Pairs(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    static int[] shortestPathTopo(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pairs>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Pairs(edges[i][1], edges[i][2]));
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topoSort(graph, st, visited, i);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) {  // checks if the distance to the current node (dist[node]) is not Integer.MAX_VALUE
                // before updating its neighbors' distances
                for (Pairs p : graph.get(node)) {
                    if (dist[node] + p.weight < dist[p.node]) {
                        dist[p.node] = dist[node] + p.weight;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    private static void topoSort(ArrayList<ArrayList<Pairs>> graph, Stack<Integer> st, boolean[] visited, int node) {
        visited[node] = true;

        for (Pairs p : graph.get(node)) {
            if (!visited[p.node]) {
                topoSort(graph, st, visited, p.node);
            }
        }

        st.push(node);
    }


    public static void main(String[] args) {
//        int n = 4, m = 2;
//        int[][] edge = {{0, 1, 2}, {0, 2, 1}};

        int n = 10, m = 24;
        int[][] edge = {
                {0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6}
        };

        System.out.println(Arrays.toString(shortestPathDijkstras(n, m, edge)));
        System.out.println(Arrays.toString(shortestPathTopo(n, m, edge)));
    }

}

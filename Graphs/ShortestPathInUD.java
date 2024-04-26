package Graphs;

import java.util.*;

public class ShortestPathInUD {

    // Find Shortest path in Undirected Graph having Unit Weight

    static int[] shortestPath(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i : graph.get(node)) {
                if (dist[node] + 1 < dist[i]) {
                    dist[i] = dist[node] + 1;
                    q.offer(i);
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

    static int[] shortestPathDijkstras(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], 1));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], 1));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new Pair(src, 0));
        cost[src] = 0;

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


    public static void main(String[] args) {
//        int n = 9, m = 10, src = 0;
//        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        int n = 7, m = 10, src = 4;
        int[][] edges = {
                {1, 5},
                {1, 6},
                {2, 0},
                {3, 3},
                {4, 0},
                {4, 6},
                {5, 3},
                {5, 4},
                {6, 5},
                {6, 6}
        };

        System.out.println(Arrays.toString(shortestPath(edges, n, m, src)));
        System.out.println(Arrays.toString(shortestPathDijkstras(edges, n, m, src)));
    }

}

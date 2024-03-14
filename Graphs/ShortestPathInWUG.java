package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInWUG {


    // Shortest Path in Weighted undirected graph

    static class Pair implements Comparable<Pair> {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }


    static List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {  // 1 based indexing
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int vertex = curr.node;

            for (Pair p : graph.get(vertex)) {
                int node = p.node;
                int weight = p.weight;

                if (dist[vertex] + weight < dist[node]) {
                    dist[node] = dist[vertex] + weight;
                    parent[node] = vertex;
                    pq.add(new Pair(node, dist[node]));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        int node = n;
        while (parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        ans.add(dist[n]);
        Collections.reverse(ans);

        return ans;
    }


    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};

        System.out.println(shortestPath(n, m, edges));
    }

}

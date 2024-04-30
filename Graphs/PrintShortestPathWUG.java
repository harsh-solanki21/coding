package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPathWUG {

    // https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    static List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            graph[edges[i][0]].add(new Pair(edges[i][1], edges[i][2]));
            graph[edges[i][1]].add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(1, 0));
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (!visited[curr.node]) {
                visited[curr.node] = true;

                for (Pair p : graph[curr.node]) {
                    if (dist[curr.node] + p.weight < dist[p.node]) {
                        dist[p.node] = dist[curr.node] + p.weight;
                        parent[p.node] = curr.node;
                        pq.offer(new Pair(p.node, dist[p.node]));
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        int i = n;
        while (parent[i] != i) {
            ans.add(i);
            i = parent[i];
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

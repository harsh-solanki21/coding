package Graphs;

import java.util.*;

public class ShortestPathInWUG {


    // Shortest Path in Weighted undirected graph

    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int vertex = p.node;

            if (!visited[vertex]) {
                visited[vertex] = true;
                for (Pair pair : graph.get(vertex)) {
                    int currNode = pair.node;
                    int currWeight = pair.weight;

                    if (dist[vertex] + currWeight < dist[currNode]) {
                        dist[currNode] = dist[vertex] + currWeight;
                        pq.add(new Pair(currNode, dist[currNode]));
                        parent[currNode] = vertex;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (parent[n] == 0) {
            ans.add(-1);
            return ans;
        }

        int len = n;
        while (parent[len] != 0) {
            ans.add(len);
            len = parent[len];
        }
        ans.add(1);
        ans.add(dist[n]);

        Collections.reverse(ans);
        return ans;
    }


    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
//        int n = 6, m = 5;
//        int[][] edges = {{2, 5, 6}, {1, 4, 4}, {3, 6, 1}, {4, 5, 5}, {1, 2, 2}};

        System.out.println(shortestPath(n, m, edges));
    }

}

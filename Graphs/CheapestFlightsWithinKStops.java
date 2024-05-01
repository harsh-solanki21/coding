package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    static class Pair {
        int adjNode, weight;

        public Pair(int adjNode, int weight) {
            this.adjNode = adjNode;
            this.weight = weight;
        }
    }

    static class Tuple {
        int node, cost, stops;

        Tuple(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(src, 0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple curr = q.remove();
            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

            for (Pair p : graph.get(node)) {
                int adjNode = p.adjNode;
                int weight = p.weight;
                if (cost + weight < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + weight;
                    q.add(new Tuple(adjNode, cost + weight, stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }


    public static void main(String[] args) {
//        int n = 4, src = 0, dst = 3, k = 1;
//        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

//        int n = 3, src = 0, dst = 2, k = 0;
//        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        int n = 5, src = 0, dst = 4, k = 1;
        int[][] flights = {{1, 2, 10}, {2, 0, 7}, {1, 3, 8}, {4, 0, 10}, {3, 4, 2}, {4, 2, 10}, {0, 3, 3}, {3, 1, 6}, {2, 4, 5}};

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

}

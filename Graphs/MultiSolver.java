package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MultiSolver {

    // Smallest, Longest, Ceil, Floor, Kth largest path
    static class Edge {
        int source;
        int dest;
        int weight;

        Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int weight;
        String ans;

        Pair(int weight, String ans) {
            this.weight = weight;
            this.ans = ans;
        }

        public int compareTo(Pair o) {
            // will sort in ascending order of weight
            return this.weight - o.weight;

            // will sort in descending order of weight
//            return o.weight - this.weight;
        }
    }


    // Multi-solver
    static String sPath;
    static Integer sPathWeight = Integer.MAX_VALUE;
    static String lPath;
    static Integer lPathWeight = Integer.MIN_VALUE;
    static String ceilPath;
    static Integer ceilPathWeight = Integer.MAX_VALUE;
    static String floorPath;
    static Integer floorPathWeight = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

    static void multisolver(ArrayList<ArrayList<Edge>> graph, int source, int dest, boolean[] visited, int criteria, int k, String ans, int currWeight) {
        if (source == dest) {
            if (currWeight < sPathWeight) {
                sPathWeight = currWeight;
                sPath = ans;
            }
            if (currWeight > lPathWeight) {
                lPathWeight = currWeight;
                lPath = ans;
            }
            if (currWeight > criteria && currWeight < ceilPathWeight) {
                ceilPathWeight = currWeight;
                ceilPath = ans;
            }
            if (currWeight < criteria && currWeight > floorPathWeight) {
                floorPathWeight = currWeight;
                floorPath = ans;
            }
            if (pq.size() < k) {
                pq.add(new Pair(currWeight, ans));
            } else {
                if (currWeight > pq.peek().weight) {
                    pq.remove();
                    pq.add(new Pair(currWeight, ans));
                }
            }
            return;
        }

        visited[source] = true;
        for (Edge edge : graph.get(source)) {
            if (!visited[edge.dest]) {
                multisolver(graph, edge.dest, dest, visited, criteria, k, ans + edge.dest, currWeight + edge.weight);
            }
        }
        visited[source] = false;

    }


    public static void main(String[] args) {
        int vertices = 7, edges = 8;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // vertices
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Edges
        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(1).add(new Edge(1, 2, 10));
        graph.get(2).add(new Edge(2, 3, 10));
        graph.get(0).add(new Edge(0, 3, 10));
        graph.get(3).add(new Edge(3, 4, 2));
        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(5).add(new Edge(5, 6, 3));
        graph.get(4).add(new Edge(4, 6, 8));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 0, 10));
        graph.get(4).add(new Edge(4, 3, 2));
        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(6).add(new Edge(6, 5, 3));
        graph.get(6).add(new Edge(6, 4, 8));

        int source = 0, dest = 6;
        int criteria = 25, k = 3;
        multisolver(graph, source, dest, new boolean[vertices], criteria, k, source + "", 0);

        System.out.println("Smallest Path = " + sPath + " @ " + sPathWeight);
        System.out.println("Largest Path = " + lPath + " @ " + lPathWeight);
        System.out.println("Just larger path(ceil) than " + criteria + " = " + ceilPath + " @ " + ceilPathWeight);
        System.out.println("Just smaller path(floor) than " + criteria + " = " + floorPath + " @ " + floorPathWeight);
        System.out.println(k + "th largest path = " + pq.peek().ans + " @ " + pq.peek().weight);
    }

}

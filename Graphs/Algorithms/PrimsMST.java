package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsMST {

    // Prim's Algorithm is a MST algorithm that takes a graph as input and finds the subset of the edges of that graph which:
    // form a tree that includes every vertex
    // has the minimum sum of weights among all the trees that can be formed from the graph

    // It falls under a class of algorithms called greedy algorithms that find the local optimum in the hopes of finding a global optimum.

    // TC - O(E * log E)


    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

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


    static int primsAlgo(ArrayList<Edge>[] graph, int vertices) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[vertices];
        pq.add(new Pair(0, 0));
        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int vertex = curr.node;
            int weight = curr.weight;

            if (!visited[vertex]) {
                visited[vertex] = true;
                mstCost += weight;

                for (Edge e : graph[vertex]) {
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }

        return mstCost;
    }


    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));


        System.out.println(primsAlgo(graph, vertices));
    }

}

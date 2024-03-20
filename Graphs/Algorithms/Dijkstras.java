package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras {

    // Purpose: find the shortest path between nodes in a graph

    // Requirements:
    // Dijkstra's Algorithm can only work with graphs that have positive weights.
    // This is because, during the process, the weights of the edges have to be added to find the shortest path.

    // If there is a negative weight in the graph, then the algorithm will not work properly.
    // Once a node has been marked as "visited", the current path to that node is marked as the shortest path to reach that node.
    // And negative weights can alter this if the total weight can be decremented after this step has occurred.


    // Dijkstra’s algorithm works on both Directed and Undirected Graphs

    // It is same as BFS, just use PriorityQueue instead of Queue

    // TC - O(E * Log V) where, E is the number of edges and V is the number of vertices
    // SC - O(V)

    // The only difference between a queue and a priority queue is that we have to traverse all connected nodes of a current node
    // and find the minimum among them when we use a normal queue which takes time of O(V).
    // But using the priority queue we can optimize it to O(log V).
    // The Time Complexity of Dijkstra’s Algorithm using a normal queue is O(V^2).



    // using ArrayList<Edge>[]

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


    static int[] dijkstra(ArrayList<Edge>[] graph, int vertices, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[vertices];

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int vertex = curr.node;
            if (!visited[vertex]) {
                visited[vertex] = true;

                for (int i = 0; i < graph[vertex].size(); i++) {
                    Edge e = graph[vertex].get(i);
                    int src = e.src;
                    int dest = e.dest;
                    int weight = e.weight;
                    if (dist[src] + weight < dist[dest]) {  // relaxation
                        dist[dest] = dist[src] + weight;
                        pq.add(new Pair(dest, dist[dest]));
                    }
                }

            }
        }

        return dist;
    }


    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 2, 2));

        graph[2].add(new Edge(2, 0, 4));
        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 5, 6));

        graph[3].add(new Edge(3, 2, 3));
        graph[3].add(new Edge(3, 5, 2));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 5, 3));

        graph[5].add(new Edge(5, 2, 6));
        graph[5].add(new Edge(5, 3, 2));
        graph[5].add(new Edge(5, 4, 3));

        int src = 1;
        System.out.println(Arrays.toString(dijkstra(graph, vertices, src)));
    }




    // using ArrayList<ArrayList<Pair>>

//    static class Pair implements Comparable<Pair> {
//        int node, weight;
//
//        Pair(int node, int weight) {
//            this.node = node;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Pair o) {
//            return this.weight - o.weight;  // Ascending order sorting
//        }
//    }
//
//
//    static int[] dijkstra(ArrayList<ArrayList<Pair>> graph, int vertices, int src) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        int[] dist = new int[vertices];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        boolean[] visited = new boolean[vertices];
//        dist[src] = 0;
//        pq.add(new Pair(src, 0));
//
//        while (!pq.isEmpty()) {
//            Pair curr = pq.remove();
//            int vertex = curr.node;
//
//            if (!visited[vertex]) {
//                visited[vertex] = true;
//                for (Pair p : graph.get(vertex)) {
//                    int node = p.node;
//                    int weight = p.weight;
//                    if (dist[vertex] + weight < dist[node]) {  // relaxation
//                        dist[node] = dist[vertex] + weight;
//                        pq.add(new Pair(node, dist[node]));
//                    }
//                }
//            }
//        }
//
//        return dist;
//    }
//
//
//    public static void main(String[] args) {
//        int vertices = 6;
//        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
//        for (int i = 0; i < vertices; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        // Undirected
////        graph.get(0).add(new Pair(1, 4));
////        graph.get(0).add(new Pair(2, 4));
////
////        graph.get(1).add(new Pair(0, 4));
////        graph.get(1).add(new Pair(2, 2));
////
////        graph.get(2).add(new Pair(0, 4));
////        graph.get(2).add(new Pair(1, 2));
////        graph.get(2).add(new Pair(3, 3));
////        graph.get(2).add(new Pair(4, 1));
////        graph.get(2).add(new Pair(5, 6));
////
////        graph.get(3).add(new Pair(2, 3));
////        graph.get(3).add(new Pair(5, 2));
////
////        graph.get(4).add(new Pair(2, 1));
////        graph.get(4).add(new Pair(5, 3));
////
////        graph.get(5).add(new Pair(2, 6));
////        graph.get(5).add(new Pair(3, 2));
////        graph.get(5).add(new Pair(4, 3));
//
//        // Directed
//        graph.get(0).add(new Pair(1, 2));
//        graph.get(0).add(new Pair(2, 4));
//
//        graph.get(1).add(new Pair(2, 1));
//        graph.get(1).add(new Pair(3, 7));
//
//        graph.get(2).add(new Pair(4, 3));
//
//        graph.get(3).add(new Pair(5, 1));
//
//        graph.get(4).add(new Pair(3, 2));
//        graph.get(4).add(new Pair(5, 5));
//
//
//        int src = 0;
//        System.out.println(Arrays.toString(dijkstra(graph, vertices, src)));
//
//    }

}

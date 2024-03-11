package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class IsGraphBipartite {

    // If it is possible to divide the vertices of graph into 2 mutually exclusive and exhaustive subsets such that
    // all the edges are across set.

    // Every non-cyclic and acyclic graph is bipartite.
    // If there is cycle in a graph then the cycle should be of even size to make graph bipartite.
    // If the cycle is of odd size then the graph won't be bipartite.

    static class Edge {
        int source;
        int neighbour;

        Edge(int source, int neighbour) {
            this.source = source;
            this.neighbour = neighbour;
        }
    }

    static class Pair {
        int vertex;
        String pathSoFar;
        int level;

        Pair(int vertex, String pathSoFar, int level) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.level = level;
        }
    }


    // Is graph bipartite
    static boolean checkBipartite(ArrayList<ArrayList<Edge>> graph, int source, int[] visited) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(source, source + "", 0));

        while (q.size() > 0) {
            Pair rem = q.removeFirst();

            if (visited[rem.vertex] != -1) {
                if (rem.level != visited[rem.vertex]) {
                    return false;
                }
            } else {
                visited[rem.vertex] = rem.level;
            }

            for (Edge e : graph.get(rem.vertex)) {
                if (visited[e.neighbour] == -1) {
                    q.add(new Pair(e.neighbour, rem.pathSoFar + e.neighbour, rem.level + 1));
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // vertices
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Cyclic even vertices graph
//        graph.get(0).add(new Edge(0, 1));
//        graph.get(2).add(new Edge(0, 2));
//        graph.get(4).add(new Edge(1, 3));
//        graph.get(5).add(new Edge(2, 4));
//        graph.get(4).add(new Edge(3, 5));
//        graph.get(4).add(new Edge(4, 5));
//
//        graph.get(1).add(new Edge(1, 0));
//        graph.get(3).add(new Edge(2, 0));
//        graph.get(5).add(new Edge(3, 1));
//        graph.get(6).add(new Edge(4, 2));
//        graph.get(6).add(new Edge(5, 3));
//        graph.get(6).add(new Edge(5, 4));


        // Cyclic odd vertices graph
        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 2));
        graph.get(1).add(new Edge(1, 3));
        graph.get(2).add(new Edge(2, 4));
        graph.get(3).add(new Edge(3, 4));

        graph.get(1).add(new Edge(1, 0));
        graph.get(2).add(new Edge(2, 0));
        graph.get(3).add(new Edge(3, 1));
        graph.get(4).add(new Edge(4, 2));
        graph.get(4).add(new Edge(4, 3));


        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == -1) {
                boolean isBipartite = checkBipartite(graph, i, visited);
                if (!isBipartite) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }

}

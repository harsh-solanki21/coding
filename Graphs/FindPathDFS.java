package Graphs;

import java.util.ArrayList;

public class FindPathDFS {

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

    static void display(ArrayList<ArrayList<Edge>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j).dest + "-" + graph.get(i).get(j).weight + ", ");
            }
            System.out.println();
        }
    }


    // Find Path
    static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int source, int dest, boolean[] visited) {
        if (source == dest) {
            return true;
        }

        visited[source] = true;
        for (Edge edge : graph.get(source)) {
            if (!visited[edge.dest]) {
                boolean hasNeighbourPath = hasPath(graph, edge.dest, dest, visited);
                if (hasNeighbourPath) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int vertices = 7, edges = 8;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // vertices
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // edges
        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(1).add(new Edge(1, 2, 10));
        graph.get(2).add(new Edge(2, 3, 10));
        graph.get(0).add(new Edge(0, 3, 10));
        graph.get(3).add(new Edge(3, 4, 10));
        graph.get(4).add(new Edge(4, 5, 10));
        graph.get(5).add(new Edge(5, 6, 10));
        graph.get(4).add(new Edge(4, 6, 10));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 0, 10));
        graph.get(4).add(new Edge(4, 3, 10));
        graph.get(5).add(new Edge(5, 4, 10));
        graph.get(6).add(new Edge(6, 5, 10));
        graph.get(6).add(new Edge(6, 4, 10));

//        display(graph);
        System.out.println(hasPath(graph, 0, 6, new boolean[vertices]));

    }


    // Using ArrayList of Array
//    static void display(ArrayList<Edge>[] graph) {
//        for (int i = 0; i < graph.length; i++) {
//            System.out.print(i + " -> ");
//            for (int j = 0; j < graph[i].size(); j++) {
//                System.out.print(graph[i].get(j).dest + "-" + graph[i].get(j).weight + ", ");
//            }
//            System.out.println();
//        }
//    }
//
//
//    // find path
//    static boolean hasPath(ArrayList<Edge>[] graph, int source, int dest, boolean[] visited) {
//        if (source == dest) {
//            return true;
//        }
//
//        visited[source] = true;
//        for (Edge edge : graph[source]) {
//            if (!visited[edge.dest]) {
//                boolean hasNeighbourPath = hasPath(graph, edge.dest, dest, visited);
//                if (hasNeighbourPath) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//
//    public static void main(String[] args) {
//        int vertices = 7, edges = 8;
//        ArrayList<Edge>[] graph = new ArrayList[vertices];
//        for (int i = 0; i < vertices; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        // edges
//        graph[0].add(new Edge(0, 1, 10));
//        graph[1].add(new Edge(1, 2, 10));
//        graph[2].add(new Edge(2, 3, 10));
//        graph[0].add(new Edge(0, 3, 10));
//        graph[3].add(new Edge(3, 4, 10));
//        graph[4].add(new Edge(4, 5, 10));
//        graph[5].add(new Edge(5, 6, 10));
//        graph[4].add(new Edge(4, 6, 10));
//
//        // also need to add this because of undirected graph
//        graph[1].add(new Edge(1, 0, 10));
//        graph[2].add(new Edge(2, 1, 10));
//        graph[3].add(new Edge(3, 2, 10));
//        graph[3].add(new Edge(3, 0, 10));
//        graph[4].add(new Edge(4, 3, 10));
//        graph[5].add(new Edge(5, 4, 10));
//        graph[6].add(new Edge(6, 5, 10));
//        graph[6].add(new Edge(6, 4, 10));
//
//        display(graph);
//        boolean[] visited = new boolean[vertices];
//        System.out.println(hasPath(graph, 0, 6, visited));
//
//    }

}

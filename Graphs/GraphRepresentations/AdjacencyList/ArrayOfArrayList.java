package Graphs.GraphRepresentations.AdjacencyList;

import java.util.ArrayList;

public class ArrayOfArrayList {

    static class Edge {
        int source, destination;
        // add weight for weighted graph

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);

        // print 2's neighbours
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.destination + " ");
        }
    }

}

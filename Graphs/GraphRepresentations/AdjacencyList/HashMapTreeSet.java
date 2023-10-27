package Graphs.GraphRepresentations.AdjacencyList;

import java.util.HashMap;
import java.util.TreeSet;

public class HashMapTreeSet {

    static void addEdge(HashMap<Integer, TreeSet<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    static void printGraph(HashMap<Integer, TreeSet<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (Integer integer : graph.get(i)) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    static void searchEdge(HashMap<Integer, TreeSet<Integer>> graph, int src, int dest) {
        if (graph.get(src).contains(dest)) {
            System.out.println("Edge from " + src + " to " + dest + " found");
        } else {
            System.out.println("Edge from " + src + " to " + dest + " not found");
        }
    }


    public static void main(String[] args) {
        int vertices = 5;
        HashMap<Integer, TreeSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new TreeSet<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        printGraph(graph);

        searchEdge(graph, 2, 1);
        searchEdge(graph, 0, 3);
    }

}

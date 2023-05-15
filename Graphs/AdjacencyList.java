package Graphs;

import java.util.ArrayList;

public class AdjacencyList {

    // All graph problems will somehow use a grid or network in the problem, but sometimes these will be well disguised.
    // Secondly, if you are required to find a path of any sort, it is usually a graph problem as well.
    // Some common keywords associated with graph problems are:
    // vertices, nodes, edges, connections, connectivity, paths, cycles and direction.

    // SC - O(2n)
    // In case of weighted graph, use Pair in ArrayList.

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                if (j != 0)
                    System.out.print(", " + graph.get(i).get(j));
                else
                    System.out.print(graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertex);

        //creating array lists for storing lists
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 3, 4);

        printGraph(graph);
    }

}

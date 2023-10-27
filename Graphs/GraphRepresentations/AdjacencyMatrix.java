package Graphs.GraphRepresentations;

public class AdjacencyMatrix {

    // Use Adjacency Matrix only when vertices < 10000
    // SC - O(n^2)
    // In case of weighted graph, put wight in the matrix instead of 1.

    static void addEdge(int[][] graph, int source, int destination) {
        graph[source][destination] = 1;
        graph[destination][source] = 1;
    }

    static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        int[][] graph = new int[vertex][vertex];

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        printGraph(graph);
    }

}

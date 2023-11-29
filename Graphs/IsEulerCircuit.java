package Graphs;

import java.util.ArrayList;
import java.util.List;

public class IsEulerCircuit {

    // Question:
    // An Eulerian Path is a path in graph that visits every edge exactly once, and it starts and ends up at different indexes.
    // An Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex.
    // Given an undirected acyclic graph with V nodes, and E edges, with adjacency list graph,
    // return 2 if the graph contains an eulerian circuit,
    // return 1 if the graph contains an eulerian path,
    // return 0 otherwise.

    static int isEulerCircuit(List<Integer>[] graph, int vertices) {
        int even = 0, odd = 0;
        for (int i = 0; i < vertices; i++) {
            if (graph[i].size() % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return even == vertices ? 2 : odd == 2 ? 1 : 0;
    }

    public static void main(String[] args) {
//           0
//         /   \
//        1 --- 2
//        Following is an eulerian circuit in the mentioned graph:
//        1 -> 2 -> 0 -> 1

        int vertices = 3;
        List<Integer>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; ++i) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);
        graph[1].add(2);

        graph[2].add(1);
        graph[2].add(2);

        System.out.println(isEulerCircuit(graph, vertices));
    }

}

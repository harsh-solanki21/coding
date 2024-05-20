package Graphs;

public class ConnectingTheGraph {

    // https://www.geeksforgeeks.org/problems/connecting-the-graph/1

    static int solve(int n, int[][] edge) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int extraEdges = 0;
        for (int i = 0; i < edge.length; i++) {
            int src = findRoot(parent, edge[i][0]);
            int dest = findRoot(parent, edge[i][1]);
            if (src == dest) {
                extraEdges++;
            } else {
                parent[dest] = src;
            }
        }

        int componentCount = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                componentCount++;
            }
        }

        int ans = componentCount - 1;  // need 1 less edge than total components to connect (E.g. to connect 4 components, we need 3 edges)

        return extraEdges >= ans ? ans : -1;
    }

    private static int findRoot(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }


    public static void main(String[] args) {
        int n = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};
        System.out.println(solve(n, edge));
    }

}

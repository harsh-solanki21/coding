package Graphs;

import java.util.Arrays;

public class CityWithThresholdDistance {


    // Find the City With the Smallest Number of Neighbors at a Threshold Distance

    // While using Dijkstra's, compute dijkstra for every node

    // Floyd-Warshall
    // TC - O(V^3), where V = no. of vertices
    // SC - O(V^2)
    static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] i : dist) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for (int i = 0; i < edges.length; i++) {
            dist[edges[i][0]][edges[i][1]] = edges[i][2];
            dist[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dist[j][i] == Integer.MAX_VALUE || dist[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        int cityCount = n, cityNo = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= cityCount) {
                cityCount = count;
                cityNo = i;
            }
        }

        return cityNo;
    }


    public static void main(String[] args) {
        int n = 5, distanceThreshold = 2;
        int[][] edges = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

}

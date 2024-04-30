package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    static class Node {
        int row, col, dist;

        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static int minimumEffortPath(int[][] heights) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] i : dist) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int diff = curr.dist;

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = dr[i] + row;
                int newCol = dc[i] + col;
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);
                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.offer(new Node(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));
    }

}

package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {


    static class Node {
        int x, y, step;

        Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }


    // GFG - Find the shortest distance from source to destination (4 directional movement)

    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] i : dist) {
            Arrays.fill(i, -1);
        }

        dist[source[0]][source[1]] = 0;
        q.offer(new Node(source[0], source[1], 0));

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node p = q.poll();
            int r = p.x;
            int c = p.y;
            int step = p.step;

            if (r == destination[0] && c == destination[1]) {
                return step;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = r + row[i];
                int newCol = c + col[i];

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1 && dist[newRow][newCol] == -1) {
                    dist[newRow][newCol] = step + 1;
                    q.offer(new Node(newRow, newCol, step + 1));
                }
            }
        }

        return -1;
    }


    // Find the shortest path from top-left cell to bottom-right cell (8 directional movement)

    static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] i : dist) {
            Arrays.fill(i, -1);
        }

        dist[0][0] = 1;
        q.offer(new Node(0, 0, 1));

        int[] row = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] col = {1, 1, 0, -1, -1, -1, 0, 1};
        while (!q.isEmpty()) {
            Node p = q.poll();
            int r = p.x;
            int c = p.y;
            int step = p.step;

            if (r == grid.length - 1 && c == grid[0].length - 1) {
                return step;
            }

            for (int i = 0; i < 8; i++) {
                int newRow = r + row[i];
                int newCol = c + col[i];

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 0 && dist[newRow][newCol] == -1) {
                    dist[newRow][newCol] = step + 1;
                    q.offer(new Node(newRow, newCol, step + 1));
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        // GFG
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}
        };
        int[] source = {0, 1};
        int[] destination = {4, 0};
        System.out.println(shortestPath(grid, source, destination));

        // Leetcode
//        int[][] matrix = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
//        System.out.println(shortestPathBinaryMatrix(matrix));
    }

}

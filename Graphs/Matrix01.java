package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    // https://leetcode.com/problems/01-matrix/
    // can be solved using DP
    static class Node {
        int x, y, distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int first = node.x + row[i];
                int second = node.y + col[i];
                if (first >= 0 && second >= 0 && first < mat.length && second < mat[0].length) {
                    if (!visited[first][second]) {
                        mat[first][second] = node.distance + 1;
                        visited[first][second] = true;
                        q.offer(new Node(first, second, node.distance + 1));
                    }
                }
            }
        }

        return mat;
    }


    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1}, {1, 1, 0}, {1, 1, 1}};
        int[][] ans = updateMatrix(mat);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }

}

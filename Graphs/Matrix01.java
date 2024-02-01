package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Matrix01 {

    // https://leetcode.com/problems/01-matrix/
    static class Pair {
        int first, second, steps;

        Pair(int first, int second, int stpes) {
            this.first = first;
            this.second = second;
            this.steps = stpes;
        }
    }

    static int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0)
                    q.add(new Pair(i, j, 0));
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int first = q.peek().first;
            int second = q.peek().second;
            int steps = q.peek().steps;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int x = first + row[i];
                int y = second + col[i];
                if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
                    if (mat[x][y] == 0) {
                        mat[x][y] = steps;
                    }
                }
            }
        }

        return mat;
    }


    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ans = updateMatrix(mat);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }

}

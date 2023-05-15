package Matrices;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonally {

    // https://leetcode.com/problems/sort-the-matrix-diagonally/

    // APPROACH - 1
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int[][] diagonalSort(int[][] mat) {
        int[][] seen = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (seen[i][j] != 1) {
                    loadQueue(mat, i, j);
                    loadDiagonal(mat, seen, i, j);
                }
            }
        }

        return mat;
    }


    private static void loadQueue(int[][] mat, int i, int j) {
        if (i >= mat.length || j >= mat[0].length || i < 0 || j < 0) {
            return;
        }
        pq.add(mat[i][j]);
        loadQueue(mat, i + 1, j + 1);
    }

    private static void loadDiagonal(int[][] mat, int[][] seen, int i, int j) {
        if (i >= mat.length || j > mat[0].length || i < 0 || j < 0 || pq.isEmpty()) {
            return;
        }
        mat[i][j] = pq.poll();
        seen[i][j] = 1;
        loadDiagonal(mat, seen, i + 1, j + 1);
    }


    // APPROACH - 2
    static int[][] diagonalSort2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            sortDiagonal(matrix, i, 0);
        }
        for (int i = 0; i < n; i++) {
            sortDiagonal(matrix, 0, i);
        }

        return matrix;
    }

    private static void sortDiagonal(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = i;
        int col = j;

        while (i < m && j < n) {
            int k = row;
            int l = col;

            while (k < m - 1 && l < n - 1) {
                if (matrix[k][l] > matrix[k + 1][l + 1]) {
                    int temp = matrix[k][l];
                    matrix[k][l] = matrix[k + 1][l + 1];
                    matrix[k + 1][l + 1] = temp;
                }

                k++;
                l++;
            }

            i++;
            j++;
        }
    }


    public static void main(String[] args) {
        int[][] mat = {{11, 25, 66, 1, 69, 7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58, 8},
                {22, 27, 33, 25, 68, 4},
                {84, 28, 14, 11, 5, 50}};

        int[][] ans = diagonalSort(mat);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }

        int[][] res = diagonalSort2(mat);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }

}

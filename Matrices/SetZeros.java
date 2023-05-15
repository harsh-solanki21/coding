package Matrices;

import java.util.Arrays;

public class SetZeros {

    // Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
    static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, k = 0;
        while (k < n && matrix[0][k] != 0) {
            k++;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (k < n) {
            Arrays.fill(matrix[0], 0);
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for (int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
    }

}

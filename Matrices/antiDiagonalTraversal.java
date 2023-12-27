package Matrices;

import java.util.Arrays;

public class antiDiagonalTraversal {

    static int[] antiDiagonalPattern(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n * n];
        int sum = 0, k = 0;

        while (sum != 2 * n - 1) {
            int i = 0, j = sum;
            if (sum > (n - 1)) {
                i = sum - (n - 1);
                j = n - 1;
            }
            for (; i <= n - 1 && j >= 0; i++, j--) {
                ans[k++] = matrix[i][j];
            }
            sum++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 2, 3},
                {4, 5, 1},
                {7, 8, 9}
        };

        System.out.println(Arrays.toString(antiDiagonalPattern(matrix)));
    }

}

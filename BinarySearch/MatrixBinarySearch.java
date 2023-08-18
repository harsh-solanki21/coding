package BinarySearch;

import java.util.Arrays;

public class MatrixBinarySearch {

    // Matrix is sorted (row wise and column wise)
    // This is not strictly sorted array like
    // 1 2 3 4
    // 5 6 7 8
    // 9 10 11 12

    // Time Complexity = O(n)
    // Reducing the search space to get the result
    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;  // matrix[0].length because it will handle 1D array also (corner case)

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return new int[]{row, column};
            }
            if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] nums = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}};
        int target = 37;
        System.out.println(Arrays.toString(search(nums, target)));
    }

}

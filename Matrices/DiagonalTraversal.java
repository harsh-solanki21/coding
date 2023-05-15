package Matrices;

public class DiagonalTraversal {

    static void diagonalTraversal(int[][] nums) {
        for (int g = 0; g < nums.length; g++) {
            for (int i = 0, j = g; j < nums.length; i++, j++) {
                System.out.print(nums[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{11, 12, 13, 14, 15},
                {21, 22, 23, 24, 25},
                {31, 32, 33, 34, 35},
                {41, 42, 43, 44, 45},
                {51, 52, 53, 54, 55}};
        diagonalTraversal(nums);  // half diagonal traversal
    }

}

package Matrices;

public class SaddlePoint {

    // Saddle Point - In 2D Square Matrix, a number/character which is minimum in its row but maximum in its column is called saddle point.
    // There will be only one saddle point in a matrix. There can be the case where there is no saddle point in a matrix.

    static int findSaddlePoint(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minRow = nums[i][0], colIndex = 0;
            for (int j = 1; j < nums[0].length; j++) {
                if (minRow > nums[i][j]) {
                    minRow = nums[i][j];
                    colIndex = j;
                }
            }

            int k;
            for (k = 0; k < nums.length; k++)
                if (minRow < nums[k][colIndex])
                    break;

            if (k == nums.length)
                return minRow;

        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(findSaddlePoint(nums));
    }

}

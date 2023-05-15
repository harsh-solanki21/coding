package Matrices;

public class ExitPointOfMatrix {

    static void exitPoint(int[][] nums) {
        // 0 -> east, 1 - south, 2 - west, 3 - north
        int direction = 0, i = 0, j = 0;
        while (true) {
            direction = (direction + nums[i][j]) % 4;
            if (direction == 0)  // east
                j++;
            else if (direction == 1)  // south
                i++;
            else if (direction == 2)  // west
                j--;
            else if (direction == 3)  // north
                i--;

            if (i < 0) {
                i++;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (i == nums.length) {
                i--;
                break;
            } else if (j == nums[0].length) {
                j--;
                break;
            }
        }
        System.out.println(i + " " + j);
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {1, 0, 1, 0}};
        exitPoint(nums);
    }

}

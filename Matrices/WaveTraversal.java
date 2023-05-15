package Matrices;

public class WaveTraversal {

    static void waveTraverse(int[][] nums) {
        for (int j = 0; j < nums[0].length; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < nums.length; i++)
                    System.out.println(nums[i][j] + " ");
            }
            else {
                for (int i = nums.length - 1; i >= 0; i--)
                    System.out.println(nums[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34}};
        waveTraverse(nums);
    }

}

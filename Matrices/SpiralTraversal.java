package Matrices;

public class SpiralTraversal {

    static void spiralTraversal(int[][] nums) {
        int top = 0;
        int bottom = nums.length - 1;
        int left = 0;
        int right = nums[0].length - 1;

        while (left <= right) {
            int temp = left;
            while (temp <= bottom)
                System.out.print(nums[temp++][left] + " ");
            temp = ++left;

            while (temp <= right)
                System.out.print(nums[bottom][temp++] + " ");
            temp = --bottom;

            while (temp >= top)
                System.out.print(nums[temp--][right] + " ");
            temp = --right;

            while (temp >= left)
                System.out.print(nums[top][temp--] + " ");
            ++top;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34}, {41, 42, 43, 44}};
        spiralTraversal(nums);
    }

}

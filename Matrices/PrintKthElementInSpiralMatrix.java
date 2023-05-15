package Matrices;

public class PrintKthElementInSpiralMatrix {

    // Given a 2D Matrix of order n X m, print K’th element in the spiral form of the matrix.
    static int spiralPrint(int[][] nums, int k) {
        int top = 0;
        int left = 0;
        int bottom = nums.length - 1;
        int right = nums[0].length - 1;
        int i = 1;
        while (top <= bottom) {
            int temp = top;
            while (temp <= right) {
                if (i == k)
                    return nums[top][temp];
                temp++;
                i++;
            }
            temp = ++top;

            while (temp <= bottom) {
                if (i == k)
                    return nums[temp][right];
                temp++;
                i++;
            }
            temp = --right;

            while (temp >= left) {
                if (i == k)
                    return nums[bottom][temp];
                temp--;
                i++;
            }
            temp = --bottom;

            while (temp >= top) {
                if (i == k)
                    return nums[temp][left];
                temp--;
                i++;
            }
            ++left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18}};
        int k = 17;
        System.out.println(spiralPrint(nums, k));
    }

}

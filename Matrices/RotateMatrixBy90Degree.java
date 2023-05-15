package Matrices;

public class RotateMatrixBy90Degree {

    static void rotate(char[][] nums) {
        // Transpose
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums[0].length; j++) {
                char temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        // Swap Columns
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = nums[i].length - 1;
            while (left < right) {
                char temp = nums[i][left];
                nums[i][left] = nums[i][right];
                nums[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Better Solution
    static void rotate90Clockwise(char[][] nums) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = nums.length - 1; i >= 0; i--)
                System.out.print(nums[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] nums = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}, {'m', 'n', 'o', 'p'}};
//        rotate(nums);
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums[i].length; j++) {
//                System.out.print(nums[i][j] + " ");
//            }
//            System.out.println();
//        }

        // Better Solution Call
        rotate90Clockwise(nums);
    }

}

package Matrices;

public class ShellRotate {

    static void rotateShell(int[][] nums, int shell, int rotations) {
        int[] arr = fillArrFromShell(nums, shell);
        rotate(arr, rotations);
        fillShellFromArr(nums, shell, arr);
    }

    static int[] fillArrFromShell(int[][] nums, int shell) {
        int top = shell - 1;
        int left = shell - 1;
        int bottom = nums.length - shell;
        int right = nums[0].length - shell;
        int size = 2 * (bottom - top + right - left);

        int[] arr = new int[size];
        int index = 0;
        int temp = top;
        // Left
        while (temp <= bottom)
            arr[index++] = nums[temp++][left];
        temp = ++left;

        // Bottom
        while (temp <= right)
            arr[index++] = nums[bottom][temp++];
        temp = --bottom;

        // Right
        while (temp >= top)
            arr[index++] = nums[temp--][right];
        temp = --right;

        // Top
        while (temp >= left)
            arr[index++] = nums[top][temp--];

        return arr;
    }

    static void rotate(int[] arr, int rotate) {
        rotate %= arr.length;
        if (rotate < 0)
            rotate += arr.length;
        reverse(arr, 0, arr.length - rotate - 1);
        reverse(arr, arr.length - rotate, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static void fillShellFromArr(int[][] nums, int shell, int[] arr) {
        int top = shell - 1;
        int left = shell - 1;
        int bottom = nums.length - shell;
        int right = nums[0].length - shell;

        int index = 0;
        int temp = top;
        // Left
        while (temp <= bottom)
            nums[temp++][left] = arr[index++];
        temp = ++left;

        // Bottom
        while (temp <= right)
            nums[bottom][temp++] = arr[index++];
        temp = --bottom;

        // Right
        while (temp >= top)
            nums[temp--][right] = arr[index++];
        temp = --right;

        // Top
        while (temp >= left)
            nums[top][temp--] = arr[index++];
    }

    public static void main(String[] args) {
        int[][] nums = {{11, 12, 13, 14, 15, 16}, {21, 22, 23, 24, 25, 26}, {31, 32, 33, 34, 35, 36}, {41, 42, 43, 44, 45, 46},
                {51, 52, 53, 54, 55, 56}, {61, 62, 63, 64, 65, 66}};
        int shell = 2;  // which shell do you want to rotate
        // Shell 1 will be the most outer box. In this case shell 2 will be
        // 22, 32, 42, 52, 53, 54, 55, 45, 35, 25, 24, 23
        int rotations = 3;  // no. of rotations (if positive then rotate anticlockwise, if negative then rotate clockwise)
        rotateShell(nums, shell, rotations);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

}

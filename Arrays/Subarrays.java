package Arrays;

public class Subarrays {

    // Iterative Approach   O(n^3)
    static void subArrays(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
        }
    }

    // Recursive Approach   O(n^2)
    static void subArraysRecursive(int[] nums, int start, int end) {
        if (end == nums.length)
            return;
        else if (start > end)
            subArraysRecursive(nums, 0, end + 1);
        else {
//            System.out.print("[");
            for (int i = start; i <= end; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
//            System.out.println(arr[end] + "]");
            subArraysRecursive(nums, start + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        subArrays(nums);
//        subArraysRecursive(nums, 0, 0);
    }

}

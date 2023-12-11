package SlidingWindow;

public class FirstNegative {

    // First Negative Number in every window of size K

    // Brute force O(n^2)
    static void firstNegative(int[] nums, int k) {
        for (int i = 0; i < nums.length - k + 1; i++) {
            boolean flag = true;
            for (int j = i; j < i + k; j++) {
                if (nums[j] < 0) {
                    System.out.print(nums[j] + " ");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(0 + " ");
            }
        }
    }

    // Efficient Approach   TC - O(n) , SC - O(k)
    static void firstNegativeEfficient(int[] nums, int k) {

    }


    // Optimized Approach   TC - O(n) , SC - O(1)
    static void firstNegativeOptimized(int[] nums, int k) {

    }


    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        firstNegative(nums, k);
        firstNegativeEfficient(nums, k);
        firstNegativeOptimized(nums, k);
    }

}

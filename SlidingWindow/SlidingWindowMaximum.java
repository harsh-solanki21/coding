package SlidingWindow;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    // Brute force approach
    // TC - O(n*k), SC - O(1)
    static int[] printMaximum(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                if (nums[i + j] > max) {
                    max = nums[i + j];
                }
            }
            res[idx++] = max;
        }
        return res;
    }


    // Optimized Approach using Deque
    //TC - O(n), SC - O(k)
    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ri = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);

            if (i >= k - 1) {
                res[ri++] = nums[dq.peek()];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(printMaximum(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

}

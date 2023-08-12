import java.util.*;

public class Main {

    // https://leetcode.com/problems/product-of-array-except-self/description/

    static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int prod = 1;
        for (int j = nums.length - 2; j > -1; j--) {
            prod *= nums[j + 1];
            ans[j] *= prod;
        }
        return ans;
    }

    static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }

    static int[] productExceptSelf4(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(productExceptSelf3(nums)));
//    }

    // search target in rotated sorted array with duplicates
    static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[start]) {
                start++;
                continue;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

//    public static void main(String[] args) {
//        int[] nums = {1, 0, 1, 1, 1};
//        int target = 0; // 3
//        System.out.println(search(nums, target));
//    }

}
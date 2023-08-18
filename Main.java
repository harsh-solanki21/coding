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

    // Recursion
    // subset, subsequence with and without duplicate (recursive, iterative)
    // Permutations (recursive, iterative)

}
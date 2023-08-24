package RecursionBasic;

import java.util.Arrays;

public class FirstLastAll_Indices {

    static int firstIndex(int[] nums, int target, int i) {
        if (i == nums.length) {
            return -1;
        }
        if (nums[i] == target) {
            return i;
        }
        return firstIndex(nums, target, i + 1);
    }

    static int lastIndex(int[] nums, int target, int i) {
        if (i == 0) {
            return nums[0];
        }
        if (nums[i] == target) {
            return i;
        }
        return lastIndex(nums, target, i - 1);
    }

    static int[] allIndices(int[] nums, int target, int i, int count) {
        if (i == nums.length) {
            return new int[count];
        }
        if (nums[i] == target) {
            int[] ans = allIndices(nums, target, i + 1, count + 1);
            ans[count] = i;
            return ans;
        } else {
            int[] ans = allIndices(nums, target, i + 1, count);
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 8, 7, 4, 3, 2, 5, 3, 3, 6, 1, 2, 3, 5, 7};
        int target = 3;
        System.out.println(firstIndex(nums, target, 0));
        System.out.println(lastIndex(nums, target, nums.length - 1));
        System.out.println(Arrays.toString(allIndices(nums, target, 0, 0)));
    }

}

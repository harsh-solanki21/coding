package BinarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 7, 7, 7, 8, 8, 10};
        int target = 7;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

}

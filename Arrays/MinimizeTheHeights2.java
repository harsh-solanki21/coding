package Arrays;

import java.util.Arrays;

public class MinimizeTheHeights2 {

//    Given an array arr[] denoting heights of N towers and a positive integer K.

//    For each tower, you must perform exactly one of the following operations exactly once.
//    Increase the height of the tower by K
//    Decrease the height of the tower by K

//    Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

//    You can find a slight modification of the problem here.
//    Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

    static int getMinDiff(int[] nums, int k) {
        Arrays.sort(nums);
        int maxi = nums[nums.length - 1], mini = nums[0], ans = nums[nums.length - 1] - nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - k < 0) {
                continue;
            }

            mini = Math.min(nums[0] + k, nums[i + 1] - k); // there will be two partition, first array minimum will be arr[0] + k and second array minimum will be arr[i + 1] - k
            maxi = Math.max(nums[i] + k, nums[nums.length - 1] - k); // there will be two partition, first array maximum will be arr[i] + k and second array maximum will be arr[n - 1] - k

            ans = Math.min(ans, maxi - mini);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {3, 9, 12, 16, 20};
        int k = 3;

        System.out.println(getMinDiff(nums, k));
    }

}

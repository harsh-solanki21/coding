package Arrays;

import java.util.Arrays;

public class FindPairSumInRotatedSortedArray {

    static int[] pairInSortedRotated(int[] nums, int target) {
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i + 1;
                break;
            }
        }

        int start = pivot;
        int end = pivot - 1;

        while (start != end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{start, end};
            }
            if (nums[start] + nums[end] < target) {
                start = (start + 1) % nums.length;
            } else {
                end = (nums.length + end - 1) % nums.length;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {11, 15, 26, 38, 9, 10};
        int target = 35;
        System.out.println(Arrays.toString(pairInSortedRotated(nums, target)));
    }

}

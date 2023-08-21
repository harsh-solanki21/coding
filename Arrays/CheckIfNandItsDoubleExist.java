package Arrays;

import java.util.Arrays;

public class CheckIfNandItsDoubleExist {

    static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static boolean checkIfExist(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < 0) {
                int ans = binarySearch(nums, 2 * nums[i], 0, i - 1);
                if (ans != -1) {
                    return true;
                }
            } else {
                int ans = binarySearch(nums, 2 * nums[i], i + 1, nums.length - 1);
                if (ans != -1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 14, 11};
        System.out.println(checkIfExist(nums));
    }

}

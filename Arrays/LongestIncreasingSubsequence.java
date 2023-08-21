package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    static List<Integer> list = new ArrayList<>();

    static int lengthOfLIS(int[] nums) {
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                list.set(binarySearch(num), num);
            }
        }
        return list.size();
    }

    private static int binarySearch(int num) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == num) {
                return mid;
            } else if (list.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

}

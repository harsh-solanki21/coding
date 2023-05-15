package Arrays;

import java.util.Arrays;
import java.util.List;

public class SmallerNumbersAfterSelf {

    // https://leetcode.com/problems/count-of-smaller-numbers-after-self/

    // You are given an integer array nums and you have to return a new counts array.
    // The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

    static List<Integer> countSmaller(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        min--;
        int[] count = new int[max - min + 1];
        Integer[] result = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int k = nums[i] - min - 1;
            int c = 0;
            do {
                c += count[k];
                k -= (-k & k);
            } while (k > 0);
            result[i] = c;

            k = nums[i] - min;
            while (k < count.length) {
                count[k]++;
                k += (-k & k);
            }
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }

}

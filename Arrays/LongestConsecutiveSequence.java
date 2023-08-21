package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {

    // TC - O(n * log n), SC - O(1)
    static int longestConsecutive1(int[] nums) {
        Arrays.sort(nums);
        int count = 1, ans = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                count++;
                ans = Math.max(ans, count);
            } else if (nums[i] + 1 != nums[i + 1] && nums[i] != nums[i + 1]) {
                count = 1;
            }

        }

        return nums.length == 0 ? 0 : (Math.max(ans, count));
    }


    // TC - O(n), SC - O(n)
    static int longestConsecutive2(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1)) {
                map.put(nums[i], false);
            }
        }

        int maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])) {
                int curr = nums[i];
                int len = 1;

                while (map.containsKey(curr + 1)) {
                    curr += 1;
                    len += 1;
                }

                if (len > maxlen) {
                    maxlen = len;
                }
            }
        }

        return maxlen;
    }


    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive1(nums));
        System.out.println(longestConsecutive2(nums));
    }

}

package HashMap;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    // TC - O(n), SC - O(n)
    static void longestConsecutiveSequence(int[] nums) {

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, true);
        }

        for (int val : nums) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }

        int maxStartPoint = 0, maxLen = 0;
        for (int val : nums) {
            if (map.get(val)) {
                int tempLen = 1;
                int tempStartPoint = val;

                while (map.containsKey(tempStartPoint + tempLen)) {
                    tempLen++;
                }

                if (tempLen > maxLen) {
                    maxStartPoint = tempStartPoint;
                    maxLen = tempLen;
                }
            }
        }

        for (int i = 0; i < maxLen; i++) {
            System.out.println(maxStartPoint + i);
        }

    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};
        // 1 2 3
        // 5 6
        // 8 9 10 11 12  - longest consecutive sequence
        // 15

        // if there are 2 results that has the same no. of longest consecutive sequence
        // then return the first
        longestConsecutiveSequence(nums);
    }

}

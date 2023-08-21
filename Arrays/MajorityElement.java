package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Sorting - O(n logn)
    static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

    // HashMap  TC - O(n), SC - O(n)
    static int majorityElement2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }

        return 0;
    }

    // Moore Voting Algorithm - O(n)
    static int majorityElement3(int[] nums) {
        int count = 0, candidate = 0;

        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }

            if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement1(nums));
        System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
    }

}

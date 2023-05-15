package HashMap;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

//    Given an array of integers nums, return the number of good pairs.
//    A pair (i, j) is called good if nums[i] == nums[j] and i < j.

    static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int numPairs = 0;
        for (int i : hm.values()) {
            //Handshake formula
            numPairs += (i * (i - 1)) / 2;
        }

        return numPairs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(nums));
    }

}

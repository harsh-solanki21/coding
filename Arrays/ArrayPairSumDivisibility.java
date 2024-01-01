package Arrays;

import java.util.HashMap;

public class ArrayPairSumDivisibility {

//    Given an array of integers nums and a number k,
//    write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.

    static boolean canPair(int[] nums, int k) {
        if (nums.length % 2 != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % k;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : nums) {
            int b = k - i;
            if (i != 0) {
                if (map.containsKey(i) == map.containsKey(b) && map.get(i) == map.get(b)) {
                    map.remove(i);
                    map.remove(b);
                } else {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] nums = {9, 5, 7, 3};
        int k = 6;
        System.out.println(canPair(nums, k));

        int[] nums2 = {4, 4, 4};
        int k2 = 4;
        System.out.println(canPair(nums2, k2));
    }

}

package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> terms = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (terms.containsKey(target - nums[i])) {
                return new int[]{terms.get(target - nums[i]), i};
            }
            terms.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

}

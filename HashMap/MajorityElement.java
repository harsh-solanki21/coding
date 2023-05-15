package HashMap;

import java.util.HashMap;

public class MajorityElement {

    // Given an integer array fo size n, find all elements that appear more than n/2 times.
    static void majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 3) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        majorityElement(nums);

        int[] arr = {1, 2};
        majorityElement(arr);
    }

}

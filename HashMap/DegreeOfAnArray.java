package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreeOfAnArray {

    static int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayList> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
            }
        }

        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(map.get(key).size(), max);
        }

        int minLen = Integer.MAX_VALUE;
        for (int n : map.keySet()) {
            if (map.get(n).size() == max) {
                ArrayList<Integer> list = map.get(n);
                int first = list.get(0);
                int last = list.get(list.size() - 1);

                minLen = Math.min(last - first + 1, minLen);

            }
        }

        return minLen;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(findShortestSubArray(nums));
    }

}

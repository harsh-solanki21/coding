import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};
        System.out.println(Arrays.toString(longestConsecutiveSequence(nums)));
    }

    static int[] longestConsecutiveSequence(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, true);
        }
        for (int i : nums) {
            if (hm.containsKey(i - 1)) {
                hm.put(i, false);
            }
        }

        int maxLen = 0;
        for(Integer key : hm.keySet()) {
            if() {

            }
        }

    }

}
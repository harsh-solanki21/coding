package HashMap;

import java.util.HashMap;

public class GetCommonElements {

    // Get Common Elements 1
    // Displays common elements once
    static void getCommonElements(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums1) {
            if (hm.containsKey(val)) {
                int oldFreq = hm.get(val);
                int newFreq = oldFreq + 1;
                hm.put(val, newFreq);
            } else {
                hm.put(val, 1);
            }
        }

        for (int val : nums2) {
            if (hm.containsKey(val)) {
                System.out.println(val);
                hm.remove(val);
            }
        }

    }


    // Get Common Elements 2
    // Displays all the common frequencies
    static void getCommonElements2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums1) {
            if (hm.containsKey(val)) {
                int olfFreq = hm.get(val);
                int newFreq = olfFreq + 1;
                hm.put(val, newFreq);
            } else {
                hm.put(val, 1);
            }
        }

        for (int val : nums2) {
            if (hm.containsKey(val) && hm.get(val) > 0) {
                System.out.println(val);
                int olfFreq = hm.get(val);
                int newFreq = olfFreq - 1;
                hm.put(val, newFreq);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {8, 3, 2, 4, 5, 2, 1, 4, 1, 2, 5, 3};
        int[] nums2 = {3, 4, 3, 2, 4, 3, 2, 2, 2, 2, 4, 8};
        getCommonElements(nums1, nums2);
//        getCommonElements2(nums1, nums2);
    }

}

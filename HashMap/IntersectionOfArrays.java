package HashMap;

import java.util.HashSet;

public class IntersectionOfArrays {

    // return count of common elements
    static int intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                count++;
                set.remove(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 3, 9, 9};
        int[] nums2 = {6, 3, 9, 2, 9, 4};
        System.out.println(intersection(nums1, nums2));
    }

}

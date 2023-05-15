package HashMap;

import java.util.HashSet;

public class UnionOfArrays {

    // Return count of unique elements:
    // Brute-force approaches
    // 1. Nested loop - O(n^2)
    // 2. Sort both the arrays - O(n logn)

    static int union(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            set.add(i);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 3, 9};
        int[] nums2 = {6, 3, 9, 2, 9, 4};
        System.out.println(union(nums1, nums2));
    }

}

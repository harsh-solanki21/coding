package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

    // When both arrays are sorted
    static ArrayList<Integer> intersectionSorted(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    // When arrays are not sorted
    static ArrayList<Integer> intersectionUnsorted(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums1) {
            hs.add(i);
        }

        for (int i : nums2) {
            if (hs.contains(i)) {
                res.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : ans) {
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 2, 3, 4};
        int[] nums2 = {2, 2, 3, 3,};
        System.out.println(intersectionSorted(nums1, nums2));
        System.out.println(intersectionUnsorted(nums1, nums2));
    }

}

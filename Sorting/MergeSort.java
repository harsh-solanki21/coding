package Sorting;

import java.util.Arrays;

public class MergeSort {

    //    Time Complexity:
    //    Total number of levels are (log n)
    //    At each level, there are total (n) comparisons being made
    //    So, the time complexity is: (total level * work at every level)
    //    O(n log(n))

    //    Space Complexity:
    //    SC is the maximum height of the tree
    //    O(n)

    static void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] first = new int[n1];
        int[] second = new int[n2];

        for (int i = 0; i < n1; i++) {
            first[i] = nums[start + i];
        }
        for (int j = 0; j < n2; j++) {
            second[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (first[i] <= second[j]) {
                nums[k] = first[i];
                i++;
            } else {
                nums[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = first[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = second[j];
            j++;
            k++;
        }
    }

    static void sort(int[] nums, int start, int end) {
        if (start < end) {
            int m = start + (end - start) / 2;
            sort(nums, start, m);
            sort(nums, m + 1, end);
            merge(nums, start, m, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}

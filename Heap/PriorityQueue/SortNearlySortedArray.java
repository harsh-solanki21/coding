package Heap.PriorityQueue;

import java.util.PriorityQueue;

public class SortNearlySortedArray {

    static void sortKSortedArray(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k + 1; i < nums.length; i++) {
            System.out.println(pq.remove());
            pq.add(nums[i]);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 6, 7, 5, 8, 9};
        int k = 3;
        sortKSortedArray(nums, k);
    }

}

package Heap.PriorityQueue;

import java.util.PriorityQueue;

public class FindKLargestElements {

    // Find K(here 3)th largest elements and print them in increasing order
    // TC - O(n log(k)), SC - O(k)
    static void findKLargestElements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.add(nums[i]);
            }
            else {
                if (nums[i] > pq.peek()) {
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 5, 17, 7, 18, 6, 4};
        int k = 3;
        findKLargestElements(nums, k);
    }

}

package PriorityQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueIntro {

    // Priority queue is Heap

    static void priorityQueue(int[] nums) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // to give high priority to large values
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // This loop will run in O(n log(n))
        // Because this loop will run n times and add() will take log(n)
        for (int val : nums) {
            pq.add(val);
        }

        // This loop will run in O(n log(n))
        // Because this loop will run n times and remove() will take log(n)
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }

    }

    public static void main(String[] args) {
        int[] ranks = {22, 99, 3, 11, 88, 4, 1};
        priorityQueue(ranks);
    }

}

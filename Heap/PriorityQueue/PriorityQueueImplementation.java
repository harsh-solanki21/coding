package Heap.PriorityQueue;

import java.util.ArrayList;

public class PriorityQueueImplementation {

    // https://www.youtube.com/watch?v=RIjxT24gUv4&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=20

    // Priority Queue Implementation using Heap.
    // Heap Order Property and Complete Binary Tree will help to perform add and remove operations in O(log n)

    // Heap Order Property
    // Parent node will be the high priority node

    // Complete Binary Tree
    // A complete binary tree is a binary tree in which all the levels are completely filled except possibly the lowest one,
    // which is filled from the left.
    // A complete binary tree is just like a full binary tree, but with two major differences.
    // All the leaf elements must lean towards the left.

    // This rule will only be followed if the tree is CBT(Complete Binary Tree)
    // leftChildIndex = 2 * parentIndex + 1
    // rightChildIndex = 2 * parentIndex + 2
    // parentIndex = (childIndex - 1) / 2

    static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue(int[] nums) {
            data = new ArrayList<>();
            for (int val : nums) {
                data.add(val);
            }

            for (int i = data.size() / 2 - 1; i >= 0; i++) {
                downHeapify(i);
            }
        }


        // 1. add element at the end
        // 2. compare it with its parent
        // 3. swap it with parent element if it's smaller than parent
        // 4. perform above operation till element gets place on correct position
        // O(log n)
        public void add(int val) {
            data.add(val);
            upHeapify(data.size() - 1);
        }

        private void upHeapify(int i) {
            if (i == 0)
                return;

            int parentIndex = (i - 1) / 2;
            if (data.get(i) < data.get(parentIndex)) {
                swap(i, parentIndex);
                upHeapify(parentIndex);
            }
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        // 1. Swap root and last element
        // 2. remove last element
        // 3. compare root and its child elements and swap root with the smallest element
        // 4. perform above operation till element gets place on correct position
        // O(log n)
        public int remove() {
            if (this.size() == 0) {
                return -1;
            }

            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downHeapify(0);
            return val;
        }

        private void downHeapify(int parentIndex) {
            int minIndex = parentIndex;
            int leftIndex = 2 * parentIndex + 1;
            if (leftIndex < data.size() && data.get(leftIndex) < data.get(minIndex)) {
                minIndex = leftIndex;
            }

            int rightIndex = 2 * parentIndex + 2;
            if (rightIndex < data.size() && data.get(rightIndex) < data.get(minIndex)) {
                minIndex = rightIndex;
            }

            if (minIndex != parentIndex) {
                swap(parentIndex, minIndex);
                downHeapify(minIndex);
            }

        }

        // O(1)
        public int peek() {
            if (this.size() == 0) {
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }

    }

    public static void main(String[] args) {
        int[] nums = {10, 2, 17, 3, 18, 9, 22};
        PriorityQueue pq = new PriorityQueue(nums);

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }

}

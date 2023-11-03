package Heap.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class Pair implements Comparable<Pair> {
        int listIndex, dataIndex, val;

        Pair(int listIndex, int dataIndex, int val) {
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    // TC - O(k), SC - O(n log(k))
    static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.size(); i++) {
            Pair p = new Pair(i, 0, nums.get(i).get(0));
            pq.add(p);
        }

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            ans.add(p.val);
            p.dataIndex++;

            if (p.dataIndex < nums.get(p.listIndex).size()) {
                p.val = nums.get(p.listIndex).get(p.dataIndex);
                pq.add(p);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        nums.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40)));
        nums.add(new ArrayList<>(Arrays.asList(5, 7, 9, 11, 19, 55, 57)));
        nums.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        nums.add(new ArrayList<>(Arrays.asList(32, 39)));

        System.out.println(mergeKSortedLists(nums));
    }

}

package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeOverlappingIntervals {

    // If there is any interval that is overlapping with the other interval then we have to merge that interval with the other interval
    // For example, 1 to 8 and 5 to 12 intervals are overlapping each other, so we can merge them and make them 1 to 12

    // Approach 1
    static class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;

        Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        // this > other return +ve
        // this = other return 0
        // this < other return -ve
        @Override
        public int compareTo(Pair other) {
            if (this.startTime != other.startTime)
                return this.startTime - other.startTime;
            else
                return this.endTime - other.endTime;
        }
    }

    static int[][] mergeOverlappingIntervals(int[][] nums) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i][0], nums[i][1]);
        }

        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            Pair top = st.peek();

            if (pairs[i].startTime > top.endTime)
                st.push(pairs[i]);
            else
                top.endTime = Math.max(top.endTime, pairs[i].endTime);
        }

        Stack<Pair> rs = new Stack<>();  // result stack
        while (!st.isEmpty()) {
            rs.push(st.pop());
        }

        int[][] ans = new int[rs.size()][2];
        int idx = 0;
        while (!rs.isEmpty()) {
            Pair p = rs.pop();
            ans[idx][0] = p.startTime;
            ans[idx][1] = p.endTime;
            idx++;
        }

        return ans;

    }


    // Approach 2
    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);

        for (int[] next : intervals) {
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                list.add(current);
            }
        }

        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        System.out.println(Arrays.toString(mergeOverlappingIntervals(intervals)));
        int[][] ans = mergeOverlappingIntervals(intervals);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}

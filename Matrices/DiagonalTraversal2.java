package Matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraversal2 {

    static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                int idx = i + j;
                if (lists.size() < idx + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(idx).add(row.get(j));
                count++;
            }
        }

        int[] ans = new int[count];
        int index = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ans[index++] = list.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        nums.add(new ArrayList<>(Arrays.asList(6, 7)));
        nums.add(new ArrayList<>(Arrays.asList(8)));
        nums.add(new ArrayList<>(Arrays.asList(9, 10, 11)));
        nums.add(new ArrayList<>(Arrays.asList(12, 13, 14, 15, 16)));

        // 1  2  3  4  5
        // 6  7
        // 8
        // 9 10 11
        // 12 13 14 15 16

        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }

}

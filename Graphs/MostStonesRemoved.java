package Graphs;

import java.util.HashMap;

public class MostStonesRemoved {

    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

    static int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int u = stones[i][0];
            int v = stones[i][1] + maxRow + 1;
            ds.unionBySize(u, v);
            stoneNodes.put(u, 1);
            stoneNodes.put(v, 1);
        }

        int count = 0;
        for (int key : stoneNodes.keySet()) {
            if (ds.find(key) == key) {
                count++;
            }
        }

        return stones.length - count;
    }


    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones));
    }

}

package Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    // https://leetcode.com/problems/rotting-oranges/
    // https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1

    // BFS Approach 1
//    static class Pair {
//        int first, second;
//
//        Pair(int first, int second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
//
//    static int orangesRotting(int[][] grid) {
//        int[] nums1 = {-1, 0, 1, 0};
//        int[] nums2 = {0, 1, 0, -1};
//        Queue<Pair> q = new ArrayDeque<>();
//        int time = 0, total = 0, rotten = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1 || grid[i][j] == 2) {
//                    total++;
//                }
//                if (grid[i][j] == 2) {
//                    q.add(new Pair(i, j));
//                }
//            }
//        }
//
//        if (total == 0) {
//            return 0;
//        }
//
//        while (!q.isEmpty() && rotten < total) {
//            int size = q.size();
//            rotten += size;
//            if (rotten == total) {
//                return time;
//            }
//            time++;
//
//            for (int a = 0; a < size; a++) {
//                Pair pair = q.remove();
//                for (int b = 0; b < 4; b++) {
//                    int i = pair.first + nums1[b];
//                    int j = pair.second + nums2[b];
//                    if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
//                        q.add(new Pair(i, j));
//                        grid[i][j] = 2;
//                    }
//                }
//            }
//        }
//
//        return -1;
//    }



    // BFS Approach 2
    static class Pair {
        int first, second;
        int time;

        Pair(int first, int second, int time) {
            this.first = first;
            this.second = second;
            this.time = time;
        }
    }

    static int orangesRotting(int[][] grid) {
        int[] nums1 = {-1, 0, 1, 0};
        int[] nums2 = {0, 1, 0, -1};
        Queue<Pair> q = new ArrayDeque<>();
        int total = 0, rotten = 0, time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    rotten++;
                }
            }
        }

        while (!q.isEmpty()) {
            int first = q.peek().first;
            int second = q.peek().second;
            time = q.peek().time;
            q.remove();

            for (int k = 0; k < 4; k++) {
                int i = first + nums1[k];
                int j = second + nums2[k];
                if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
                    q.add(new Pair(i, j, time + 1));
                    grid[i][j] = 2;
                    rotten++;
                }
            }
        }

        return rotten == total ? time : -1;
    }


    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {0, 1, 2}};
        System.out.println(orangesRotting(grid));
    }

}

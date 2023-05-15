package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FloodFill {

    // https://www.geeksforgeeks.org/flood-fill-algorithm/
    // https://leetcode.com/problems/flood-fill/

    // DFS
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void dfs(int[][] image, int i, int j, int color, int newColor) {
        if (i < 0 || j < 0 || i == image.length || j == image[0].length || image[i][j] != color || image[i][j] == newColor)
            return;

        image[i][j] = newColor;
        dfs(image, i - 1, j, color, newColor);
        dfs(image, i, j + 1, color, newColor);
        dfs(image, i + 1, j, color, newColor);
        dfs(image, i, j - 1, color, newColor);
    }


    // BFS
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[][] floodFillAlgorithm(int[][] image, int sr, int sc, int newColor) {
        int[] nums1 = {-1, 0, 1, 0};
        int[] nums2 = {0, -1, 0, 1};
        int color = image[sr][sc];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int first = q.peek().first;
            int second = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int val1 = first + nums1[i];
                int val2 = second + nums2[i];
                if (check(image, val1, val2, newColor, color)) {
                    q.add(new Pair(val1, val2));
                    image[val1][val2] = newColor;
                }
            }
        }

        return image;
    }

    private static boolean check(int[][] image, int i, int j, int newColor, int color) {
        if (i < 0 || j < 0 || i == image.length || j == image[0].length || image[i][j] != color || image[i][j] == newColor)
            return false;
        return true;
    }


    public static void main(String[] args) {
        int[][] image = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1}};
        int sr = 4, sc = 4, newColor = 3;

//        int[][] ans = floodFill(image, sr, sc, newColor);
//        for (int[] i : ans) {
//            System.out.println(Arrays.toString(i));
//        }

        int[][] ans = floodFillAlgorithm(image, sr, sc, newColor);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }

    }

}

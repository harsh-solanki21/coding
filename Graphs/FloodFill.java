package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    // https://www.geeksforgeeks.org/flood-fill-algorithm/
    // https://leetcode.com/problems/flood-fill/

    // DFS
    static int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
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
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int[] nums1 = {-1, 0, 1, 0};
        int[] nums2 = {0, 1, 0, -1};
        int oldColor = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        if (image[sr][sc] == newColor) {
            return image;
        } else {
            q.add(new Pair(sr, sc));
        }

        while (!q.isEmpty()) {
            Pair remNode = q.remove();
            image[remNode.x][remNode.y] = newColor;
            for (int i = 0; i < 4; i++) {
                int first = remNode.x + nums1[i];
                int second = remNode.y + nums2[i];
                if (first >= 0 && second >= 0 && first < image.length && second < image[0].length && image[first][second] == oldColor) {
                    q.add(new Pair(first, second));
                }
            }
        }

        return image;
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

//        int[][] ans = floodFillDFS(image, sr, sc, newColor);
//        for (int[] i : ans) {
//            System.out.println(Arrays.toString(i));
//        }

        int[][] ans = floodFillBFS(image, sr, sc, newColor);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }

    }

}

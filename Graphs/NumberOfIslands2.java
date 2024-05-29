package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {

    // Number of Islands 2
    // TC - O(Q * 4α) = ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
    // SC - O(n * m)
    static List<Integer> numOfIslands(int[][] operators, int n, int m) {
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (visited[row][col]) {
                ans.add(count);
                continue;
            }
            visited[row][col] = true;
            count++;

            int[] first = {-1, 0, 1, 0};
            int[] second = {0, 1, 0, -1};
            for (int j = 0; j < 4; j++) {
                int newRow = row + first[j];
                int newCol = col + second[j];
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    if (visited[newRow][newCol]) {
                        int u = (row * m) + col;
                        int v = (newRow * m) + newCol;
                        if (ds.find(u) != ds.find(v)) {
                            count--;
                            ds.unionBySize(u, v);
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }


    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1}, {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}};
        System.out.println(numOfIslands(operators, n, m));  // [1, 1, 2, 1, 1, 2, 2, 2, 3, 3, 1, 1]
    }

}

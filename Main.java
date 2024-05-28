import java.util.*;

class DisjointSet {
    private int[] parent;
    private int[] size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent[i]); // Path compression
        return parent[i];
    }

    void unionBySize(int i, int j) {
        int iLeader = find(i);
        int jLeader = find(j);
        if (iLeader == jLeader) {
            return;
        }
        if (size[iLeader] < size[jLeader]) {
            parent[iLeader] = jLeader;
            size[jLeader] += size[iLeader];
        } else {
            parent[jLeader] = iLeader;
            size[iLeader] += size[jLeader];
        }
    }
}

public class Main {

    // Number of Islands 2
    // TC - O(Q * 4α) = ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
    // SC - O(n * m)
    static List<Integer> numOfIslands(int[][] operators) {
        int n = operators.length, m = operators[0].length;
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
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
                        int u = row * m + col;
                        int v = newRow * m + newCol;
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
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1}, {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}};
        System.out.println(numOfIslands(operators));  // 1 1 2 1 1 2 2 2 3 3 1 1
    }

}

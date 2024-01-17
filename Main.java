import java.util.*;

public class Main {

    static class Node {
        int x, y, distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int[][] nearest(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans[i][j] = 0;
                } else {
                    bfs(grid, ans, i, j);
                }
            }
        }

        return ans;
    }

    private static void bfs(int[][] grid, int[][] ans, int i, int j) {
        int[] a = {-1, 0, 1, 0};
        int[] b = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j, 0));

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int z = 0; z < qSize; z++) {
                Node rem = q.poll();
                int x = rem.x;
                int y = rem.y;
                int distance = rem.distance;
                for (int p = 0; p < 4; p++) {
                    int first = x + a[p];
                    int second = y + b[p];
                    if (first >= 0 && first < grid.length && second >= 0 && second < grid[0].length) {
                        if (grid[first][second] == 1) {
                            ans[x][y] = distance + 1;
                            return;
                        } else {
                            q.offer(new Node(first, second, distance + 1));
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 0}
        };

        int[][] ans = nearest(grid);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }


//    public static void main(String[] args) {
//
////        0 -- 1 --- 4
////        |    |    |  \
////        2 -- 3    5 - 6
//
//        int vertices = 7;
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//
//        for (int i = 0; i < vertices; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        graph.get(0).add(1);
//        graph.get(0).add(2);
//
//        graph.get(1).add(0);
//        graph.get(1).add(3);
//        graph.get(1).add(4);
//
//        graph.get(2).add(0);
//        graph.get(2).add(3);
//
//        graph.get(3).add(1);
//        graph.get(3).add(2);
//
//        graph.get(4).add(1);
//        graph.get(4).add(5);
//        graph.get(4).add(6);
//
//        graph.get(5).add(4);
//        graph.get(5).add(6);
//
//        graph.get(6).add(4);
//        graph.get(6).add(5);
//
//    }

}

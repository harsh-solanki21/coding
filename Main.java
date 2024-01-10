import java.util.*;

public class Main {

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        int[] a = {-1, 0, 1, 0};
        int[] b = {0, 1, 0, -1};
        int time = -1;
        while (!q.isEmpty()) {
            int currSize = q.size();
            time++;
            for (int i = 0; i < currSize; i++) {
                Node rem = q.remove();
                for (int j = 0; j < 4; j++) {
                    int row = rem.x + a[j];
                    int col = rem.y + b[j];
                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.add(new Node(row, col));
                    }
                }
            }
        }

        return time;
    }


    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(grid));
    }

//    public static void main(String[] args) {
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

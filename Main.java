import java.util.*;

public class Main {

    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; i++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                Pair remQ = q.remove();
                minutes++;
                for(int j = 0; j<4; j++) {
                    int first = remQ.i + x[i];
                    int second = remQ.j + y[i];
                    if(first >= 0 && second >= 0 && first < grid.length && second < grid[0].length && grid[first][second] == 1) {
                        grid[first][second] = 2;
                        q.add(new Pair());
                    }
                }
            }
        }

        return minutes;
    }


    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
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

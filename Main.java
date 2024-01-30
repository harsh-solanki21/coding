import java.util.*;

public class Main {

    static class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int orangesRotting(int[][] grid) {
        int totalOranges = 0, rottenOranges = 0, time = 0;
        int[] a = {-1, 0, 1, 0};
        int[] b = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Node(i, j, 0));
                    rottenOranges++;
                } else if (grid[i][j] != 0) {
                    totalOranges++;
                }
            }
        }


        return totalOranges == rottenOranges ? time : -1;
    }


    public static void main(String[] args) {
        int[][] isConnected = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(isConnected));
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

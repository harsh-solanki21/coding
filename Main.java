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

    static int[][] updateMatrix(int[][] mat) {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    q.offer(new Node(i, j, 0));
                }
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int first = node.x + row[i];
                int second = node.y + col[i];
                if (first >= 0 && second >= 0 && first < mat.length && second < mat[0].length) {
                    if (mat[first][second] == 0) {
                        mat[node.x][node.y] = node.distance + 1;
                        break;
                    } else {
                        q.add(new Node(first, second, node.distance + 1));
                    }
                }
            }
        }

        return mat;
    }


    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ans = updateMatrix(mat);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }

//    static void nextPermutation(int[] nums) {
//        int index1 = -1;
//        int index2 = -1;
//
//        // step 1 find breaking point
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] < nums[i + 1]) {
//                index1 = i;
//                break;
//            }
//        }
//
//        // if there is no breaking  point
//        if (index1 == -1) {
//            reverse(nums, 0);
//            return;
//        }
//
//        // step 2 find next greater element and swap with index2
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] > nums[index1]) {
//                index2 = i;
//                break;
//            }
//        }
//
//        swap(nums, index1, index2);
//        // step 3 reverse the rest right half
//        reverse(nums, index1 + 1);
//
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    private static void reverse(int[] nums, int start) {
//        int i = start;
//        int j = nums.length - 1;
//        while (i < j) {
//            swap(nums, i, j);
//            i++;
//            j--;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int[] prices = {1, 1, 5};
//        nextPermutation(prices);
//        System.out.println(Arrays.toString(prices));
//    }


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

package Tree.BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {

    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    // Time Complexity: O(N * logN * logN * logN)
    // Space Complexity: O(N)

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Tuple {
        TreeNode node;
        int row;
        int col;

        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    static List<List<Integer>> findVertical(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List<List<Integer>> list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List<Integer> it : list) {
            for (int nodeVal : it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

    }

//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    static class Pair implements Comparable<Pair> {
//        int col;
//        int row;
//        TreeNode node;
//
//        public Pair(int r, int c, TreeNode n) {
//            row = r;
//            col = c;
//            node = n;
//        }
//
//        public int compareTo(Pair p) {
//            if (col != p.col) return col - p.col;
//            if (row != p.row) return row - p.row;
//            return node.val - p.node.val;
//        }
//    }
//
//    static int leastCol;
//    static int mostCol;
//
//    static List<List<Integer>> ans;
//    static Heap.PriorityQueue<Pair> pq;
//
//    static List<List<Integer>> verticalTraversal(TreeNode root) {
//        ans = new ArrayList<>();
//
//        bfs(root);
//        int sumCol = mostCol - leastCol + 1;
//
//        for (int i = 0; i < sumCol; i++)
//            ans.add(new ArrayList<>());
//
//        while (!pq.isEmpty()) {
//            Pair curr = pq.poll();
//            ((ArrayList<Integer>) ans.get(-leastCol + curr.col)).add(curr.node.val);
//        }
//
//        return (List<List<Integer>>) ans;
//    }
//
//    private static void bfs(TreeNode root) {
//        Queue<Pair> q = new LinkedList<Pair>();
//        pq = new Heap.PriorityQueue<>();
//        int row = 0;
//        int col = 0;
//        q.add(new Pair(row, col, root));
//        leastCol = 0;
//        mostCol = 0;
//        row = 1;
//
//        while (!q.isEmpty()) {
//            Pair curr = q.poll();
//            pq.add(curr);
//
//            if (curr.node.left != null) {
//                q.add(new Pair(curr.row + 1, curr.col - 1, curr.node.left));
//                leastCol = Math.min(leastCol, curr.col - 1);
//            }
//            if (curr.node.right != null) {
//                q.add(new Pair(curr.row + 1, curr.col + 1, curr.node.right));
//                mostCol = Math.max(mostCol, curr.col + 1);
//
//            }
//        }
//    }


}

package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumAndPrintAtKthLevel {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    static void printNodesOfKthLevel(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }

        if (k == 0) {  // because we are considering root node at level 0
            System.out.print(node.data + " ");
        }

        printNodesOfKthLevel(node.left, k - 1);
        printNodesOfKthLevel(node.right, k - 1);
    }


    static int sum;

    static void sumOfNodesAtKthLevel(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {  // because we are considering root node at level 0
            sum += node.data;
        }

        sumOfNodesAtKthLevel(node.left, k - 1);
        sumOfNodesAtKthLevel(node.right, k - 1);
    }


    static int sumOfNodesAtKthLevelIterative(Node root, int k) {
        if (root == null) {
            return 0;
        }

        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        int sum = 0;
        int flag = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                Node ptr = que.peek();
                que.remove();

                if (level == k) {
                    flag = 1;
                    sum += ptr.data;
                } else {
                    if (ptr.left != null) {
                        que.add(ptr.left);
                    }
                    if (ptr.right != null) {
                        que.add(ptr.right);
                    }
                }
            }
            level++;

            if (flag == 1) {
                break;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);
        int level = 3;

        printNodesOfKthLevel(root, level);
        System.out.println();
        sumOfNodesAtKthLevel(root, level);
        System.out.println(sum);
        System.out.print(sumOfNodesAtKthLevelIterative(root, level));
    }

}

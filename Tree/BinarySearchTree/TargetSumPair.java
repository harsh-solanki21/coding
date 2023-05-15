package Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class TargetSumPair {

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


    // print all the pairs whose sum is equal to the given target
    // print the values in the sorted manner

    // Approach 1
    // TC = O(n * h) / O(n logn), SC - O(h), where h is the height of tree
    static void targetSumPair(Node root, Node node, int target) {
        if (node == null) {
            return;
        }

        targetSumPair(root, node.left, target);
        int comp = target - node.data;
        if (node.data < comp) {
            if (find(root, comp)) {
                System.out.println(node.data + " " + comp);
            }
        }
        targetSumPair(root, node.right, target);
    }

    static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }


    // Approach 2
    // TC - O(n), SC - (n)
    static void targetsumPair2(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        targetsumPair2(node.left, list);
        list.add(node.data);
        targetsumPair2(node.right, list);
    }


    // Approach 3 (Best approach)
    // Using iterative inorder and reverse iterative inorder
    // TC - O(n), SC - (h), where h is height of tree
    static class Pair {
        Node node;
        int state = 0;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static void targetSumPair3(Node node, int target) {
        Stack<Pair> leftSt = new Stack<>();
        Stack<Pair> rightSt = new Stack<>();
        leftSt.push(new Pair(node, 0));
        rightSt.push(new Pair(node, 0));

        Node left = getNextFromNormalInorder(leftSt);
        Node right = getNextFromReverseInorder(rightSt);

        while (left.data < right.data) {
            if (left.data + right.data < target) {
                left = getNextFromNormalInorder(leftSt);
            } else if (left.data + right.data > target) {
                right = getNextFromReverseInorder(rightSt);
            } else {
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(leftSt);
                right = getNextFromReverseInorder(rightSt);

            }
        }
    }

    private static Node getNextFromNormalInorder(Stack<Pair> st) {
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new Pair(top.node.left, 0));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new Pair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        return null;
    }

    private static Node getNextFromReverseInorder(Stack<Pair> st) {
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 0) {
                if (top.node.right != null) {
                    st.push(new Pair(top.node.right, 0));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.left != null) {
                    st.push(new Pair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        return null;
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

        int target = 100;

        // Approach 1
//        targetSumPair(root, root, target);


        // Approach 2
//        ArrayList<Integer> list = new ArrayList<>();
//        targetsumPair2(root, list);
//
//        int leftIndex = 0;
//        int rightIndex = list.size() - 1;
//        while (leftIndex < rightIndex) {
//            int left = list.get(leftIndex);
//            int right = list.get(rightIndex);
//
//            if (left + right < target) {
//                leftIndex++;
//            } else if (left + right > target) {
//                rightIndex--;
//            } else {
//                System.out.println(left + " " + right);
//                leftIndex++;
//                rightIndex--;
//            }
//        }


        // Approach 3
        targetSumPair3(root, target);

    }

}

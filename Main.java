import java.util.*;

public class Main {

//    Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.
//    Output your answer modulo 109 + 7.
//    Example: n = 3
//    Output = 5 (000, 001, 010, 100, 101)

    static long countStrings(int n) {
        long mod = 1000000007;
        long zero = 1, sum = 2;
        for (int i = 2; i <= n; i++) {
            long temp = sum;
            sum = (sum + zero) % mod;
            zero = temp;
        }
        return sum % mod;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countStrings(n));
    }

}


// Tree

// Diameter of Binary Tree
// Lowest Common Ancestor
// Kth Smallest element in BST

//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.left.left.left = new Node(7);
//        root.left.left.right = new Node(8);
//        root.left.right.right = new Node(9);
//        root.left.left.right.right = new Node(10);
//        root.left.right.right.left = new Node(11);
//        root.left.left.right.right.left = new Node(12);
//        root.left.right.right.left.right = new Node(13);
//        root.left.left.right.right.left.left = new Node(14);

//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(5);
//        root.left.left = new Node(3);
//        root.left.right = new Node(4);
//        root.right.right = new Node(6);
//        root.left.left.left = new Node(7);
//        root.left.left.right = new Node(8);
//        root.left.right.left = new Node(10);
//        root.left.left.right.right = new Node(9);

//        Node ans = lowestCommonAncestor(root, root.left.left.left, root.left.left.right.right);
//        System.out.println(ans.data);

//        System.out.println(diameter(root));

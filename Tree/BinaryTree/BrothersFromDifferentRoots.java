package Tree.BinaryTree;

public class BrothersFromDifferentRoots {

//    Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x,
//    your task is to complete the function countPairs(), that returns the count of all pairs of (a, b)
//    where a belongs to one BST and b belongs to another BST, such that a + b = x.

    static Node root1, root2;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    static int countPairs(Node root1, Node root2, int x) {
        if (root1 == null) {
            return 0;
        }

        int ans = 0;
        ans += countPairs(root1.left, root2, x);

        if (find(root2, x - root1.data)) {
            ans++;
        }

        ans += countPairs(root1.right, root2, x);
        return ans;
    }

    private static boolean find(Node root, int tar) {
        if (root == null) {
            return false;
        }

        if (root.data > tar) {
            return find(root.left, tar);
        } else if (root.data < tar) {
            return find(root.right, tar);
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
//                  5
//                /   \
//               3     7
//              / \   / \
//             2   4 6   8
        root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);


//                  10
//                /    \
//               6      15
//              / \    /  \
//             3   8  11   18
        root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);


        int x = 16;
        System.out.println(countPairs(root1, root2, x));
    }

}

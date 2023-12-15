import java.util.*;

public class Main {

    static int maxSubArraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(nums));
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

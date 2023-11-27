import java.util.*;

public class Main {

    // shuffle integers
    static void rearrange(int[] nums, int n) {
        n = n / 2;
        for (int i = 0; i < n; i++) {
            int x = nums[i] << 16;
            nums[i] = x | nums[i + n];
        }

        int sixteen1s = (1 << 16) - 1;
        int j = 2 * n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int y = nums[i] & sixteen1s;
            int x = nums[i] >> 16;
            nums[j] = y;
            j--;
            nums[j] = x;
            j--;
        }
    }

    // Driver Program
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6};
        int n = arr.length;
        rearrange(arr, n);
        System.out.println(Arrays.toString(arr));
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

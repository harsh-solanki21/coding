package Tree.BinaryTree.MAANG_Ques;

public class CDLL {

    // Another Question:
    // Convert a BST into a Doubly Linked List | Facebook | Phone Screen Round


    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Convert a Binary Tree to a Circular Doubly LinkedList (Amazon)
    static Node bTreeToClist(Node root) {
        if (root == null) {
            return null;
        }
        Node left = bTreeToClist(root.left);
        Node right = bTreeToClist(root.right);

        root.left = root.right = root;

        Node leftConcat = concatenate(left, root);
        Node rightConcat = concatenate(leftConcat, right);
        return rightConcat;
    }

    private static Node concatenate(Node leftList, Node rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        Node leftLast = leftList.left;
        Node rightLast = rightList.left;

        leftLast.right = rightList;
        rightList.left = leftLast;
        leftList.left = rightLast;
        rightLast.right = leftList;

        return leftList;
    }


    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        Node ansRootNode = bTreeToClist(root);

        // Circular Doubly LinkedList Forward Traversal
        Node next = ansRootNode;
        while (next.right != ansRootNode) {
            System.out.print(next.data + " -> ");
            next = next.right;
        }
        System.out.println(next.data);

        // Circular Doubly LinkedList Backward Traversal
        Node prev = ansRootNode;
        while (prev.left != ansRootNode) {
            prev = prev.left;
            System.out.print(prev.data + " -> ");
        }
        System.out.println(prev.left.data);
    }

}

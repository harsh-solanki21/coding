package Tree.BinaryTree.MAANG_Ques;

public class NextRightPointers {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;
        Node next;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.next = null;
        }

        Node(int data, Node left, Node right, Node next) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    // Populating Next Right Pointers in Each Node
    static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current != null) {
            Node level1stNode = current;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }
                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            current = level1stNode.left;
        }
        return root;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node node = connect(root);
    }

}

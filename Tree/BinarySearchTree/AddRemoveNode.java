package Tree.BinarySearchTree;

public class AddRemoveNode {

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

    static void display(Node node) {
        if (node == null) {
            System.out.print("n ");
            return;
        }

        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }


    // Add Node in BST
    static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            // nothing to do
        }

        return node;
    }


    // Remove node in BST
    static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            if (node.left != null && node.right != null) {
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = remove(node.left, leftMax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }

        return node;
    }

    static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
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

        display(root);
        add(root, 60);
        System.out.println();
        display(root);
        remove(root, 30);
        System.out.println();
        display(root);
    }

}

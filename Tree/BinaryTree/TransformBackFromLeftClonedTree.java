package Tree.BinaryTree;

public class TransformBackFromLeftClonedTree {

//                       a
//                   /       \
//               a               c                                          a
//             /                /  \                                    /        \
//           b                c      g       --->                   b               c
//         /    \            /      /                             /   \           /   \
//       b       e         f       g                            d       e       f       g
//      /       /         /
//    d       e          f
//   /
// d
//

    static Node root;

    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
            left = right = null;
        }

        Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static void display(Node node) {
        if (node == null) {
            System.out.print(-1 + " ");
            return;
        }

        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }


    static Node transformBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        Node left = transformBackFromLeftClonedTree(node.left.left);
        Node right = transformBackFromLeftClonedTree(node.right);

        node.left = left;
        node.right = right;
        return node;
    }


    public static void main(String[] args) {
        root = new Node('a');
        root.left = new Node('a');
        root.right = new Node('c');
        root.left.left = new Node('b');
        root.right.left = new Node('c');
        root.right.right = new Node('g');
        root.left.left.left = new Node('b');
        root.right.left.left = new Node('f');
        root.left.left.right = new Node('e');
        root.right.right.left = new Node('g');
        root.left.left.left.left = new Node('d');
        root.left.left.right.left = new Node('e');
        root.right.left.left.left = new Node('f');
        root.left.left.left.left.left = new Node('d');

        Node node = transformBackFromLeftClonedTree(root);
        display(node);
    }

}

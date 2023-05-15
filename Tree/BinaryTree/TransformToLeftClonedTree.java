package Tree.BinaryTree;

public class TransformToLeftClonedTree {

//                                                                              a
//                                                                          /       \
//              a                                                       a               c
//          /       \                                                 /                /  \
//      b               c              -->                          b                c      g
//    /   \           /   \                                       /    \            /      /
//  d       e       f       g                                   b       e         f       g
//                                                             /       /         /
//                                                           d       e          f
//                                                          /
//                                                        d

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


    static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }

        Node leftCloneRoot = createLeftCloneTree(node.left);
        Node rightCloneRoot = createLeftCloneTree(node.right);

        Node newNode = new Node(node.data, leftCloneRoot, null);
        node.left = newNode;
        node.right = rightCloneRoot;

        return node;
    }


    public static void main(String[] args) {
        root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');
        root.right.right = new Node('g');

        Node node = createLeftCloneTree(root);
        display(node);
    }

}

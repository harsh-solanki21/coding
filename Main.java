import java.util.*;

public class Main {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    

//    public static void main(String[] args) {
//        root = new Node(3);
//        root.left = new Node(4);
//        root.right = new Node(8);
//        root.left.left = new Node(12);
//        root.left.right = new Node(19);
//        root.right.left = new Node(7);
//        root.right.right = new Node(11);
//        root.left.right.left = new Node(36);
//        root.left.right.right = new Node(9);
//        root.right.right.left = new Node(2);
//        root.right.right.left.right = new Node(44);
//
//    }

}
package Tree.BinaryTree.MAANG_Ques;

import java.util.*;

public class BFS {

    // Queue<Node> queue = new LinkedList<>()/ArrayDeque<>();
    // which one is better?

    // If you need add/remove of the both ends, ArrayDeque is significantly better than a linked list.
    // Random access each element is also O(1) for a cyclic queue.
    // The only better operation of a linked list is removing the current element during iteration.

    // LinkedList supports null elements, whereas ArrayDeque does not.

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


    // BFS/Level-Order Traversal
    static List<List<Integer>> bfsTraversal() {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node current = q.remove();
                currentLevel.add(current.data);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            ans.add(currentLevel);
        }

        return ans;
    }


    // Average of levels
    static List<Double> averageOfLevels(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> ans = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.remove();
                levelSum += current.data;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            ans.add(levelSum / levelSize);
        }

        return ans;
    }


    // Level Order Successor of a node
    static Node findSuccessor(Node root, int key) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            if (currentNode.data == key) {
                break;
            }
        }

        return queue.peek();
    }


    // Zigzag Level Order Traversal
    static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    Node current = q.removeFirst();
                    currentLevel.add(current.data);
                    if (current.left != null) {
                        q.addLast(current.left);
                    }
                    if (current.right != null) {
                        q.addLast(current.right);
                    }
                } else {
                    Node current = q.removeLast();
                    currentLevel.add(current.data);
                    if (current.right != null) {
                        q.addFirst(current.right);
                    }
                    if (current.left != null) {
                        q.addFirst(current.left);
                    }
                }
            }
            reverse = !reverse;
            ans.add(currentLevel);
        }

        return ans;
    }


    // Level order traversal 2 (print from bottom)
    static List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                Node currentNode = queue.remove();
                currentLevel.add(currentNode.data);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel); // result.add(0, currentLevel);
        }

        // Doesn't need this reversal if we use result.add(0, currentLevel);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            ans.add(result.get(i));
        }
        return ans;
    }


    // Binary Tree Right Side View
    static List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = q.remove();
                if (i == levelSize - 1) {
                    ans.add(currentNode.data);
                }
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }

        return ans;
    }


    // Cousins in Binary Tree (Solution 1)
    static boolean isCousins(Node root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                Node currentNode = q.remove();
                if (currentNode.left != null && currentNode.right != null) {
                    if (currentNode.left.data == x && currentNode.right.data == y) {
                        return false;
                    }
                    if (currentNode.right.data == x && currentNode.left.data == y) {
                        return false;
                    }
                }
                currentLevel.add(currentNode.data);

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
            if (currentLevel.contains(x) && currentLevel.contains(y)) {
                return true;
            }
        }

        return false;
    }


    // Cousins in Binary Tree (Solution 2)
    static boolean isCousins2(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);
        return (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy));
    }

    private static Node findNode(Node node, int x) {
        if (node == null) {
            return null;
        }
        if (node.data == x) {
            return node;
        }
        Node n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    private static boolean isSibling(Node node, Node x, Node y) {
        if (node == null) {
            return false;
        }
        return (
                (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    private static int level(Node node, Node x, int level) {
        if (node == null) {
            return 0;
        }
        if (node == x) {
            return level;
        }

        int lev = level(node.left, x, level + 1);
        if (lev != 0) {
            return lev;
        }
        return level(node.right, x, level + 1);
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.right.left.left = new Node(10);
        root.right.right.right = new Node(11);

//        List<List<Integer>> ans = bfsTraversal();
//        System.out.println(ans);

//        System.out.println(averageOfLevels(root));

//        List<List<Integer>> ans = zigzagLevelOrder(root);
//        System.out.println(ans);

//        List<List<Integer>> ans = levelOrderBottom(root);
//        System.out.println(ans);

//        System.out.println(rightSideView(root));

        System.out.println(isCousins(root, 4, 7));
        System.out.println(isCousins2(root, 4, 7));

    }

}

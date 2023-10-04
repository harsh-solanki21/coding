package Tree.GenericTree;

import java.util.*;

public class GenericTree {

    // N-array tree is known as "generic tree" where a parent can have n number of children,
    // where n is any non-negative integer. In other words, the N-array tree is an acyclic undirected graph.

    // In Generic tree, we don't need to make a base case for recursion call,
    // Because its recursion runs using loop, so when there are no children of a node then it won't make a call

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    static void display(Node node) {
        StringBuilder s = new StringBuilder(node.data + " -> ");
        for (Node child : node.children) {
            s.append(child.data).append(", ");
        }
        s.append(".");
        System.out.println(s);

        for (Node child : node.children) {
            display(child);
        }
    }


    // find size of generic tree
    // size means count the total nodes
    static int size(Node node) {
        int size = 0;
        for (Node child : node.children) {
            int childSize = size(child);
            size += childSize;
        }
        return size + 1;
    }


    // find max node in the tree
    static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int childMax = max(child);
            max = Math.max(childMax, max);
        }
        return Math.max(node.data, max);
    }


    // find height of a generic tree
    static int height(Node node) {
        int height = 0;
        for (Node child : node.children) {
            int maxHeight = height(child);
            height = Math.max(height, maxHeight);
        }
        height++;
        return height;
    }


    // Traversals
    static void traversals(Node node) {
        // Euler's left, on the way deep in the recursion, node's pre area
        System.out.println("Node pre " + node.data);  // pre-order
        for (Node child : node.children) {
            System.out.println("Edge pre " + node.data + " - " + child.data);  // Edge pre area
            traversals(child);
            System.out.println("Edge post " + node.data + " - " + child.data);  // Edge post area
        }
        // Euler's right, on the way out of recursion, node's post area
        System.out.println("Node post " + node.data);  // post-order
    }


    // Level-Order Traversal
    static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while (!q.isEmpty()) {
            node = q.remove();
            System.out.print(node.data + " ");

            for (Node child : node.children) {
                q.add(child);
            }
        }
    }


    // Level-Order Linewise
    static void levelOrderLinewise(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        Queue<Node> childQ = new ArrayDeque<>();
        while (!q.isEmpty()) {
            node = q.remove();
            System.out.print(node.data + " ");

            for (Node child : node.children) {
                childQ.add(child);
            }

            if (q.isEmpty()) {
                q = childQ;
                childQ = new ArrayDeque<>();
                System.out.println();
            }
        }
    }


    // Level-Order Linewise Zigzag
    static void levelOrderLinewiseZigzag(Node node) {
        Stack<Node> st = new Stack<>();
        st.push(node);

        Stack<Node> childSt = new Stack<>();
        int level = 1;

        while (!st.isEmpty()) {
            node = st.pop();
            System.out.print(node.data + " ");

            if (level % 2 == 1) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    childSt.push(child);
                }
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    childSt.push(child);
                }
            }

            if (st.isEmpty()) {
                st = childSt;
                childSt = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }


    // Level-Order Traversal more approaches
    // Approach 2
    static void levelOrderLinewise2(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));

        while (!q.isEmpty()) {
            node = q.remove();
            if (node.data != -1) {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    q.add(child);
                }
            } else {
                if (!q.isEmpty()) {
                    q.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }


    // Approach 3
    static void levelOrderLinewise3(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while (!q.isEmpty()) {
            int cicl = q.size();  // children in current level
            for (int i = 0; i < cicl; i++) {
                node = q.remove();
                System.out.print(node.data + " ");

                for (Node child : node.children) {
                    q.add(child);
                }
            }
            System.out.println();
        }
    }


    // Approach 4
    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static void levelOrderLinewise4(Node node) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));

        int level = 1;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }

            System.out.print(p.node.data + " ");
            for (Node child : p.node.children) {
                Pair childPair = new Pair(child, p.level + 1);
                q.add(childPair);
            }
        }
    }


    // Mirror a generic tree
    // TC - O(n), O(n logn)
    static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }


    // Remove Leaves from a Generic Tree
    static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.isEmpty()) {
                node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }

        // Don't remove leaves in post order
        // because after removing leaves of a node, it will also consider node as a leaf because we removed its leaves
        // and we are checking for leaves in post order
        // so, it will remove the node also, considering it as leaf
        // That is why do this in pre-order
    }


    // Linearize a generic tree
    // It will make all the nodes single child node in preorder
    // Ex. 10 -> 20 -> 50 -> 60 -> 30 -> 70 -> 80 -> 110 -> 120 -> 90 -> 40 -> 100
    // In above example, 10 is the root node and all the other nodes are child nodes
    static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);
            Node secondLastTail = getTail(secondLast);
            secondLastTail.children.add(lastChild);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }


    // Linearize a generic tree | Efficient approach
    static Node linearize2(Node node) {
        if (node.children.isEmpty()) {
            return node;
        }

        Node lastTail = linearize2(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);
            Node secondLastTail = linearize2(secondLast);
            secondLastTail.children.add(last);
        }
        return lastTail;
    }


    // find in generic tree
    static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        for (Node child : node.children) {
            boolean found = find(child, data);
            if (found) {
                return true;
            }
        }
        return false;
    }


    // Node to root path in generic tree
    static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(node.data);
            return ans;
        }

        for (Node child : node.children) {
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);
            if (!pathTillChild.isEmpty()) {
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }


    // Lowest Common Ancestor
    static int lowestCommonAncestor(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return path1.get(i);
    }


    // Distance between nodes in generic tree
    static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }


    // Are trees similar in shape
    static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(i);
            if (!areSimilar(child1, child2)) {
                return false;
            }
        }

        return true;
    }


    // Are trees mirror in shape (check the shape, data can be different)
    static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            int j = n1.children.size() - i - 1;
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(j);
            if (!areMirror(child1, child2)) {
                return false;
            }
        }

        return true;
    }


    // Is generic tree symmetric?
    // Symmetric means you draw a line in center vertically, and you get both the side same.
    // Symmetric things are mirror image of itself
    static boolean isSymmetric(Node node) {
        return areMirror(node, node);  // symmetric if they are mirror image of itself
    }


    // Multisolver

    static int size;
    static int min;
    static int max;
    static int height;

    // Euler represents state of the stack on different moments
    // Parameter we pass in a method(here, depth), changes its value when we go deep in tree and come out of tree
    // defined in Heap remains the same (unlike passed in parameter)
    static void multisolver(Node node, int depth) {
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);

        for (Node child : node.children) {
            multisolver(child, depth + 1);
        }
    }


    // Predecessor and Successor of an element (in pre-order)
    static Node predecessor;
    static Node successor;
    static int state = 0;

    static void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (data == node.data)
                state = 1;
            else
                predecessor = node;
        } else if (state == 1) {
            successor = node;
            state = 2;
        }
        for (Node child : node.children) {
            predecessorAndSuccessor(child, data);
        }
    }


    // Ceil and Floor
    static int ceil;
    static int floor;

    static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil)
                ceil = node.data;
        }

        if (node.data < data) {
            if (node.data > floor)
                floor = node.data;
        }

        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }


    // Kth largest element
    static int kthLargest(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            ceilAndFloor(node, factor);  // will set floor
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }


    // Node with Maximum Subtree Sum
    // This question is the example where we want something in the answer, and we are returning something else
    // We want the max subtree node, and we are returning the sum
    static int maxSumNode = 0;
    static int maxSum = Integer.MIN_VALUE;

    static int maxSubtreeSum(Node node) {
        int sum = 0;

        for (Node child : node.children) {
            int currentSum = maxSubtreeSum(child);
            sum += currentSum;
        }
        sum += node.data;

        if (sum > maxSum) {
            maxSumNode = node.data;
            maxSum = sum;
        }

        return sum;
    }


    // Diameter of generic tree
    // Diameter defined as maximum number of edges between any two nodes in the tree
    // this question is also kind of where we calculate something and return something
    static int diameter = 0;

    static int calculateDiameterReturnHeight(Node node) {
        int dch = -1;  // deepestChildHeight
        int sdch = -1;  // secondDeepestChildHeight

        for (Node child : node.children) {
            int ch = calculateDiameterReturnHeight(child);  // childHeight
            if (ch > dch) {
                sdch = dch;
                dch = ch;
            } else if (ch > sdch) {
                sdch = ch;
            }
        }

        int candidate = dch + sdch + 2;
        if (candidate > diameter) {
            diameter = candidate;
        }

        dch += 1;
        return dch;
    }


    // Iterative Preorder and Postorder Traversal
    static class Pairs {
        Node node;
        int state;

        Pairs(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static void iterativePreAndPostOrder(Node node) {
        Stack<Pairs> st = new Stack<>();
        st.push(new Pairs(node, -1));

        String pre = "";
        String post = "";
        while (st.size() > 0) {
            Pairs top = st.peek();
            if (top.state == -1) {
                pre += top.node.data + " ";
                top.state++;
            } else if (top.state == top.node.children.size()) {
                post += top.node.data + " ";
                st.pop();
            } else {
                Pairs childPair = new Pairs(top.node.children.get(top.state), -1);
                st.push(childPair);
                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);
    }


    public static void main(String[] args) {
        int[] nums = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                st.pop();
            else {
                Node node = new Node();
                node.data = nums[i];

                if (!st.isEmpty()) {
                    st.peek().children.add(node);
                } else {
                    root = node;
                }
                st.push(node);
            }
        }


//        display(root);
//        System.out.println(size(root));
//        System.out.println(max(root));
//        System.out.println(height(root));
//        traversals(root);
//        levelOrder(root);
//        levelOrderLinewise(root);
//        levelOrderLinewiseZigzag(root);
//        levelOrderLinewise2(root);
//        levelOrderLinewise3(root);
//        levelOrderLinewise4(root);

//        mirror(root);
//        display(root);

//        removeLeaves(root);
//        display(root);

//        linearize(root);
//        display(root);

//        linearize2(root);
//        display(root);

//        System.out.println(find(root, 110));
//        System.out.println(nodeToRootPath(root, 110));
//        System.out.println(lowestCommonAncestor(root, 70, 110));
//        System.out.println(distanceBetweenNodes(root, 70, 110));
//        System.out.println(areSimilar(root, root));
//        System.out.println(areMirror(root, root));

//        size = 0;
//        min = Integer.MAX_VALUE;
//        max = Integer.MIN_VALUE;
//        height = 0;
//        multisolver(root, 0);
//        System.out.println("Size = " + size);
//        System.out.println("Min = " + min);
//        System.out.println("Max = " + max);
//        System.out.println("Height = " + height);

//        predecessorAndSuccessor(root, 90);
//        System.out.println(predecessor.data);
//        System.out.println(successor.data);

//        ceil = Integer.MAX_VALUE;  // smallest among larger
//        floor = Integer.MIN_VALUE;  // largest among smaller
//        ceilAndFloor(root, 65);
//        System.out.println(ceil);
//        System.out.println(floor);

//        System.out.println(kthLargest(root, 3));

//        maxSubtreeSum(root);
//        System.out.println("Maximum Sum Node: " + maxSumNode);
//        System.out.println("Maximum Sum: " + maxSum);

//        calculateDiameterReturnHeight(root);
//        System.out.println(diameter);

        iterativePreAndPostOrder(root);

    }

}

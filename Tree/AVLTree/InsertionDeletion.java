package Tree.AVLTree;

public class InsertionDeletion {

    static Node root;

    static class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            height = 1;
        }
    }

    static int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static Node rightRotate(Node node) {
        Node newNode = node.left;
        Node T2 = newNode.right;

        // Perform rotation
        newNode.right = node;
        node.left = T2;

        // Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        newNode.height = max(height(newNode.left), height(newNode.right)) + 1;

        // Return new root
        return newNode;
    }

    static Node leftRotate(Node node) {
        Node newNode = node.right;
        Node T2 = newNode.left;

        // Perform rotation
        newNode.left = node;
        node.right = T2;

        //  Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        newNode.height = max(height(newNode.left), height(newNode.right)) + 1;

        // Return new root
        return newNode;
    }

    static int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Insertion  TC - O(n * log(n))
    static Node insert(Node node, int key) {
        /* 1.  Perform the normal BST insertion */
        if (node == null) {
            return (new Node(key));
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {// Duplicate keys not allowed
            return node;
        }

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // Deletion  TC - O(log n)
    static Node deleteNode(Node root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        }

        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        }

        // if key is same as root's key, then this is the node
        // to be deleted
        else {
            // node with only one child or no child
            if (root.left == null || root.right == null) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null) {
            return root;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Searching is similar to the search operation in a normal Binary Search Tree.

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
                    9
                   / \
                  1  10
                 / \   \
                0   5   11
                   /   /  \
                 -1   2    6
        */

        System.out.println("Preorder traversal of constructed tree is : ");
        preOrder(root);

        root = deleteNode(root, 10);
        /*
                    1
                   / \
                  0   9
                 /   / \
               -1   5   11
                   / \
                  2   6
        */

        System.out.println("\n");
        System.out.println("Preorder traversal after deletion of 10 : ");
        preOrder(root);
    }

}

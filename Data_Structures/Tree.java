package Data_Structures;

// Binary Search Tree Implementation (Only Integers)
public class Tree {
    public class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Getters
        public int getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        // Setters
        public void setData(int newData) {
            data = newData;
        }

        public void setLeft(TreeNode newLeft) {
            left = newLeft;
        }

        public void setRight(TreeNode newRight) {
            right = newRight;
        }
    }
    
    private TreeNode root;

    public Tree(int rootData) {
        this.root = new TreeNode(rootData);
    }

    // Adding a node to the BST
    // Best case:   O(log n)
    // Worst case:  O(n)
    public void add(int data) {
        root = addRecursive(root, data);
    }

    // Helper method for adding a node
    private TreeNode addRecursive(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = addRecursive(node.left, data);
        } else if (data > node.data) {
            node.right = addRecursive(node.right, data);
        }
        // If data == node.data, do nothing (no duplicates in BST).
        return node;
    }

    // Removing a node from the BST
    // Best case:   O(log n)
    // Worst case:  O(n)
    public void remove(int data) {
        root = removeRecursive(root, data);
    }

    private TreeNode removeRecursive(TreeNode node, int data) {
    if (node == null) {
        return null; // Node not found
    }

    if (data < node.data) {
        node.left = removeRecursive(node.left, data);
    } else if (data > node.data) {
        node.right = removeRecursive(node.right, data);
    } else {
        // Node found
        // Case 1: No children (leaf node)
        if (node.left == null && node.right == null) {
            return null;
        }
        // Case 2: Only one child
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }
        // Case 3: Two children
        // Find the smallest node in the right subtree
        TreeNode smallestValue = findMin(node.right);
        node.data = smallestValue.data;
        // Remove the smallest node in the right subtree
        node.right = removeRecursive(node.right, smallestValue.data);
    }
    return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Traversals
    // Node -> Left -> Right
    // O(n)
    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // Node
        System.out.println(node.data + " ");
        // Left children
        preOrderTraversal(node.left);
        // Right children
        preOrderTraversal(node.right);
    }

    // Left -> Node -> Right
    // O(n)
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // Left children
        inOrderTraversal(node.left);
        // Node
        System.out.println(node.data + " ");
        // Right children
        inOrderTraversal(node.right);
        
    }

    // Left -> Right -> Node
    // O(n)
    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // Left children
        postOrderTraversal(node.left);
        // Right children
        postOrderTraversal(node.right);
        // Node
        System.out.println(node.data + " ");
    }

    // Searching for a node
    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    // Helper function for search
    private boolean searchRecursive(TreeNode node, int data) {
        if(node == null) {
            return false;
        }

        if(node.data == data) {
            return true;
        } else if (data > node.data) {
            return searchRecursive(node.right, data);
        } else {
            return searchRecursive(node.left, data);
        }   
    }

    // Method that returns the root
    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        // Create a tree with root value 10
        Tree tree = new Tree(10);
    
        System.out.println("Testing add method:");
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);
    
        System.out.println("In-order Traversal (should print sorted order): ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 3 5 7 10 12 15 18
        System.out.println();
    
        System.out.println("Pre-order Traversal: ");
        tree.preOrderTraversal(tree.getRoot()); // Output: 10 5 3 7 15 12 18
        System.out.println();
    
        System.out.println("Post-order Traversal: ");
        tree.postOrderTraversal(tree.getRoot()); // Output: 3 7 5 12 18 15 10
        System.out.println();
    
        System.out.println("\nTesting search method:");
        System.out.println("Search for 7: " + tree.search(7)); // Output: true
        System.out.println("Search for 20: " + tree.search(20)); // Output: false
    
        System.out.println("\nTesting remove method:");
        System.out.println("Removing leaf node (3):");
        tree.remove(3);
        System.out.println("In-order Traversal after removing 3: ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 5 7 10 12 15 18
        System.out.println();
    
        System.out.println("Removing node with one child (5):");
        tree.remove(5);
        System.out.println("In-order Traversal after removing 5: ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 7 10 12 15 18
        System.out.println();
    
        System.out.println("Removing node with two children (15):");
        tree.remove(15);
        System.out.println("In-order Traversal after removing 15: ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 7 10 12 18
        System.out.println();
    
        System.out.println("\nTesting edge cases:");
        System.out.println("Removing non-existent node (100):");
        tree.remove(100); // Should handle gracefully without errors
        System.out.println("In-order Traversal after attempting to remove 100: ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 7 10 12 18
        System.out.println();
    
        System.out.println("Adding duplicate value (10):");
        tree.add(10); // Should not add duplicates
        System.out.println("In-order Traversal after attempting to add duplicate 10: ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 7 10 12 18
        System.out.println();
    }    
}

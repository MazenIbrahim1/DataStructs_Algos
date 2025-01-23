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
        root.data = rootData;
    }

    // Adding a node to the BST
    public void add(int data) {
        
    }

    // Removing a node from the BST
    public void remove(int data) {

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
        Tree tree = new Tree(10);

        // Test add
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);

        // Test traversal
        System.out.print("In-order Traversal: ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 3 5 7 10 15

        System.out.println("\nSearch for 7: " + tree.search(7)); // Output: true
        System.out.println("Search for 20: " + tree.search(20)); // Output: false

        // Test remove
        tree.remove(5);
        System.out.print("In-order Traversal after removing 5: ");
        tree.inOrderTraversal(tree.getRoot()); // Output: 3 7 10 15
    }
}

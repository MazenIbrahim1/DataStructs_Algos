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

    // Traversals
    public void preOrderTraversal(TreeNode node) {
        // Node
        // Left children
        // Right children
    }

    public void inOrderTraversal(TreeNode node) {
        // Left children
        // Node
        // Right children
    }

    public void postOrderTraversal(TreeNode node) {
        // Left children
        // Right children
        // Node
    }

    // Searching for a node
    public boolean search(int data) {
        return false;
    }
}

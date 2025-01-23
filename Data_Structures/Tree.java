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
        return false;
    }
}

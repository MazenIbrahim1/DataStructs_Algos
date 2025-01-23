package Data_Structures;

public class Tree<T> {
    public class TreeNode {
        private T data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Getters
        public T getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        // Setters
        public void setData(T newData) {
            data = newData;
        }

        public void setLeft(TreeNode newLeft) {
            left = newLeft;
        }

        public void setRight(TreeNode newRight) {
            right = newRight;
        }
    }
    
}

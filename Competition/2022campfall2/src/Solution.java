class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        if (root.left != null) root.left = new TreeNode(-1,expandBinaryTree(root.left),null);
        if (root.right != null) root.right = new TreeNode(-1,null,expandBinaryTree(root.right));
        return root;
    }
}
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode tail = root.left;
            while (tail.right != null) tail = tail.right;
            tail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.left);
        flatten(root.right);
    }
}

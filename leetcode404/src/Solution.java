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
    private int res;
    public int sumOfLeftLeaves(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (root.left != null && isLeaf(root.left)) res += root.left.val;
        inOrder(root.right);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

class Solution {
    private int res;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) res += root.left.val;
            dfs(root.left);
        }
        if (root.right != null) dfs(root.right);
    }

}

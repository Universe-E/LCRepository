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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dp(root);
        return max;
    }

    private int dp(TreeNode root) {
        if (root == null) return 0;
        int l = dp(root.left), r = dp(root.right);
        max = Math.max(max,l+r);
        return Math.max(l,r) + 1;
    }
}
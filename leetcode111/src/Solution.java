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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        //l和r不可能同时为空，如果一方为空，设为无限大
        int l = root.left == null ? 100005 : minDepth(root.left);
        int r = root.right == null ? 100005 : minDepth(root.right);
        return Math.min(l,r)+1;
    }
}
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
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        getPath(root,targetSum);
        if (root.left != null) pathSum(root.left,targetSum);
        if (root.right != null) pathSum(root.right,targetSum);
        return res;
    }

    private void getPath(TreeNode root, long targetSum) {
        if (root.val == targetSum) res++;
        if (root.left != null) getPath(root.left,targetSum-root.val);
        if (root.right != null) getPath(root.right, targetSum-root.val);
    }
}
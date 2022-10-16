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
    boolean valid = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root,0,targetSum);
        return valid;
    }

    private void dfs(TreeNode root,int sum,int targetSum) {
        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum == targetSum) valid = true;
            return;
        }
        if (root.left != null) dfs(root.left,sum + root.val,targetSum);
        if (root.right != null) dfs(root.right,sum + root.val,targetSum);
    }
}
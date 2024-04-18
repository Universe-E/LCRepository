class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    TreeNode res = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned,target);
        return res;
    }

    private void dfs(TreeNode cloned, TreeNode target) {
        if (cloned == null) return;
        if (cloned.val == target.val) {
            res = cloned;
            return;
        }
        dfs(cloned.left,target);
        dfs(cloned.right,target);
    }
}
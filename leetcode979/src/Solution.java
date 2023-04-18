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
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        //负数表示下一步要从根节点扣除金币，整数表示向根节点返回金币
        int l = dfs(root.left);
        int r = dfs(root.right);
        res += Math.abs(l) + Math.abs(r);
        //减一表示当前节点留下一个金币
        return l + r + root.val - 1;
    }
}
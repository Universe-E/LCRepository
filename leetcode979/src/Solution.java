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
        //负数表示下一步要从根节点扣除金币，正数表示向根节点返回金币
        int l = dfs(root.left);
        int r = dfs(root.right);
        res += Math.abs(l) + Math.abs(r);
        //减一表示当前节点留下一个金币
        return l + r + root.val - 1;
    }
}

class Solution {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0,0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        //统计每棵树的总节点数和总硬币数
        int nodes = l[0]+r[0]+1,coins = l[1]+r[1]+root.val;
        res += Math.abs(coins-nodes);//多了上交给root的父节点，少了从root的父节点拿
        return new int[] {nodes,coins};
    }
}
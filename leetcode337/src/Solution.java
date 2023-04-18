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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    //如果偷该节点，存储在res[0],否则存储在res[1]
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int[] res = new int[2];
        //如果偷当前节点，则只能取l[1]和r[1]
        res[0] = root.val + l[1] + r[1];
        //如果不偷当前节点，那么0和1都可以选
        res[1] = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return res;
    }
}
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
    int result = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return result;
    }

    //树形dp
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0,0};
        int[] res = new int[2];//res[0]记录左边的dfs结果，res[1]记录右边的dfs结果
        int[] lr = dfs(root.left);
        int[] rr = dfs(root.right);
        //以下是zigzag过程
        res[0] = lr[1] + (root.left == null ? 0 : 1);
        res[1] = rr[0] + (root.right == null ? 0 : 1);
        //在搜索过程中更新result
        result = Math.max(result,Math.max(res[0],res[1]));
        return res;
    }
}
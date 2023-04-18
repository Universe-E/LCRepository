class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public double minimalExecTime(TreeNode root) {
        double[] arr = dfs(root);
        return arr[0]-arr[1];
    }

   //arr[0]代表总消耗时间，arr[1]代表并行消耗时间
    private double[] dfs(TreeNode root) {
        if (root == null) return new double[] {0,0};
        double[] ls = dfs(root.left);
        double[] rs = dfs(root.right);
        //lt,lp分别代表左节点的总耗时和并行耗时
        double lt = ls[0], lp = ls[1], rt = rs[0], rp = rs[1];
        double total = lt + rt + root.val;
        if ((rt >= lt && rt - 2*rp <= lt) || (lt >= rt && lt-2*lp <= rt)) return new double[] {total,(lt+rt)/2};
        if (lt - 2*lp > rt) return new double[] {total, lp + rt};
        else return new double[] {total, rp + lt};
    }
}
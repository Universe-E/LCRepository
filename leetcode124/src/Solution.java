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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) return 0;
        int lMax = Math.max(0,getMax(root.left));
        int rMax = Math.max(0,getMax(root.right));

        int route = root.val + lMax + rMax;
        res = Math.max(res,route);
        return root.val + Math.max(lMax,rMax);
    }
}
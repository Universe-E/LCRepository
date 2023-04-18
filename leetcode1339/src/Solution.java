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
    long res = 0;
    public int maxProduct(TreeNode root) {
        int total = dfsSum(root);
        int M = (int)(1e9+7);
        inOrder(root,total);
        return (int) (res % M);
    }

    //根节点求和，根节点值等于当前整棵树的值加和
    private int dfsSum(TreeNode root) {
        if (root == null) return 0;
        int l = dfsSum(root.left);
        int r = dfsSum(root.right);
        root.val += l + r;
        return root.val;
    }

    //断开当前根节点所在子树，与剩下的值相乘，找最大结果
    private void inOrder(TreeNode root,int total) {
        if (root == null) return;
        inOrder(root.left,total);
        long curMulti = (long)root.val * (long)(total - root.val);
        if (curMulti >= res) res = curMulti;
        inOrder(root.right,total);
    }
}
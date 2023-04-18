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
    public int maxAncestorDiff(TreeNode root) {
        preOrder2(root);
        return res;
    }

    private void preOrder(TreeNode node,int rv) {
        if (node == null) return;
        res = Math.max(res,Math.abs(node.val-rv));
        preOrder(node.left,rv);
        preOrder(node.right,rv);
    }

    private void preOrder2(TreeNode node) {
        if (node == null) return;
        preOrder(node,node.val);
        preOrder2(node.left);
        preOrder2(node.right);
    }
}

class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        getMaxAndMin(root,root.val,root.val);
        return res;
    }

    //同时维护最大值和最小值
    private void getMaxAndMin(TreeNode root,int max,int min) {
        if (root == null) return;
        int curMax = Math.max(root.val,max),curMin = Math.min(root.val,min);
        res = Math.max(res,Math.max(Math.abs(root.val-curMax),Math.abs(root.val-curMin)));
        getMaxAndMin(root.left,curMax,curMin);
        getMaxAndMin(root.right,curMax,curMin);
    }
}
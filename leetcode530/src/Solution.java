import java.util.ArrayList;

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
    int res = 100005;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (pre != -1) res = Math.min(res,node.val-pre);
        pre = node.val;
        inOrder(node.right);
    }
}
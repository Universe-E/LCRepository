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
    public int goodNodes(TreeNode root) {
        preOrder(root,root.val);
        return res;
    }

    private void preOrder(TreeNode node,int mx) {
        if (node == null) return;
        if (node.val >= mx) res++;
        preOrder(node.left,Math.max(mx,node.val));
        preOrder(node.right,Math.max(mx,node.val));
    }

}
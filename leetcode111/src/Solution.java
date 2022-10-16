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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root)) return 1;
        //同时都不为空才能相加，不然会把子树的结果丢失
        if (root.left != null && root.right != null) return 1 + Math.min(minDepth(root.left),minDepth(root.right));
        //否则说明子节点有一个为空，则和另一个不为空的子节点相加即可
        return 1 + (root.left == null ? minDepth(root.right) : minDepth(root.left));

    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
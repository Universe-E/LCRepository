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
    public TreeNode pruneTree(TreeNode root) {
        return deleteZero(root);
    }

    private TreeNode deleteZero(TreeNode node) {

        if (node.left != null) deleteZero(node.left);
        if (node.right != null) deleteZero(node.right);

        //满足剪枝的条件最底层情况
        if (node.left != null && isLeaf(node.left) && node.left.val == 0) node.left = null;
        if (node.right != null && isLeaf(node.right) && node.right.val == 0) node.right = null;
        if (isLeaf(node) && node.val == 0) node = null;

        return node;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

class Solution2 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}

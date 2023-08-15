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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        if (root1 == null && root2 == null) return null;
        if (root1 == null || root2 == null) root.val = root1 == null ? root2.val : root1.val;
        else root.val = root1.val + root2.val;
        root.left = mergeTrees(root1 == null ? null : root1.left,root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right,root2 == null ? null : root2.right);
        return root;
    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        else return new TreeNode(root1.val+root2.val,
                mergeTrees(root1.left,root2.left),
                mergeTrees(root1.right,root2.right));
    }
}


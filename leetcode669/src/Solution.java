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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return delete(root,low,high);
    }

    private TreeNode delete(TreeNode root,int low, int high) {
        if (root == null) return null;
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val > high) root = root.left;
            else root = root.right;
        }

        if (root != null) {
            root.left = delete(root.left, low, high);
            root.right = delete(root.right, low, high);
        }
        return root;
    }
}

class Solution2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right,low,high);
        if (root.val > high) return trimBST(root.left, low, high);
        else {
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
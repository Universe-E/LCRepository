import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    boolean valid = true;
    public boolean isBalanced(TreeNode root) {
        inOrder(root);
        return valid;
    }

    private int inOrder(TreeNode root) {
        if (root == null) return 0;
        int l = inOrder(root.left);
        int r = inOrder(root.right);
        if (Math.abs(l - r) > 1) {
            valid = false;
            return -1;
        }
        else return Math.max(l,r) + 1;
    }
}
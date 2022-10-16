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
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,-2147483649L,2147483648L);
    }

    private boolean isValid(TreeNode root,long lower,long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return isValid(root.left,lower,root.val) && isValid(root.right,root.val,upper);
    }
}

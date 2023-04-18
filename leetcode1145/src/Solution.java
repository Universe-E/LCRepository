import java.util.Arrays;

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
    //声明每个节点的子节点个数（包含自己）
    int[] cs;
    //fa为父节点，lc和rc为左右子节点
    int fa = -1,lc = -1, rc = -1,x;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        cs = new int[n+1];
        this.x = x;
        getCnt(root);
        //分别考察从x的父节点、左节点、右节点三个方向封堵
        if (fa != -1 && n-cs[x] > cs[x]) return true;
        if (lc != -1 && cs[lc] > n-cs[lc]) return true;
        if (rc != -1 && cs[rc] > n-cs[rc]) return true;
        //如果没有父节点，也没有左右节点，说明二叉树只有一个节点，此时返回false
        return false;
    }

    private int getCnt(TreeNode root) {
        if (root == null) return 0;
        if ((root.left != null && root.left.val == x) ||
                (root.right != null && root.right.val == x)) fa = root.val;
        if (root.val == x) {
            if (root.left != null) lc = root.left.val;
            if (root.right != null) rc = root.right.val;
        }
        int l = getCnt(root.left);
        int r = getCnt(root.right);
        cs[root.val] = l+r+1;
        return l+r+1;
    }
}
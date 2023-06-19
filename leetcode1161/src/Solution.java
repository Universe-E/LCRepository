import java.util.ArrayDeque;

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
    int mx = Integer.MIN_VALUE;
    public int maxLevelSum(TreeNode root) {
        var q = new ArrayDeque<TreeNode>();
        q.add(root);
        int row = -1,id = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            int cur = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode p = q.pollFirst();
                cur += p.val;
                if (p.left != null) q.addLast(p.left);
                if (p.right != null) q.addLast(p.right);
            }
            if (cur > mx) {
                mx = cur;
                row = id;
            }
            id++;
        }
        return row;
    }
}
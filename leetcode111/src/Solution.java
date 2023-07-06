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

//tree-dp
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        //l和r不可能同时为空，如果一方为空，设为无限大
        int l = root.left == null ? 100005 : minDepth(root.left);
        int r = root.right == null ? 100005 : minDepth(root.right);
        return Math.min(l,r)+1;
    }
}

//bfs
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        var q = new ArrayDeque<TreeNode>();
        q.addLast(root);
        int d = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                var p = q.pollFirst();
                assert p != null;
                if (p.left == null && p.right == null) return d;
                if (p.left != null) q.addLast(p.left);
                if (p.right != null) q.addLast(p.right);
            }
            d++;
        }
        return d;
    }
}
import java.util.ArrayDeque;
import java.util.ArrayList;
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        var q = new ArrayDeque<TreeNode>();
        if (root != null) q.addLast(root);
        while (!q.isEmpty()) {
            int sz = q.size(),mx = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                var t = q.pollFirst();
                assert t != null;
                mx = Math.max(mx,t.val);
                if (t.left != null) q.addLast(t.left);
                if (t.right != null) q.addLast(t.right);
            }
            res.add(mx);
        }
        return res;
    }
}
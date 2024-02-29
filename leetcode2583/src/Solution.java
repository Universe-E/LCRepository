import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> list = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            long cur = 0, n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.pollFirst();
                assert t != null;
                cur += t.val;
                if (t.left != null) q.addLast(t.left);
                if (t.right != null) q.addLast(t.right);
            }
            list.add(cur);
        }
        if (list.size() < k) return -1;
        list.sort(Comparator.reverseOrder());
        return list.get(k-1);
    }
}
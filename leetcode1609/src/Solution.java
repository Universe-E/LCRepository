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
    public boolean isEvenOddTree(TreeNode root) {
        int d = 0;
        var q = new ArrayDeque<TreeNode>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                var t = q.pollFirst();
                assert t != null;
                list.add(t.val);
                if (t.left != null) q.addLast(t.left);
                if (t.right != null) q.addLast(t.right);
            }
            if (!ok(list,d)) return false;
            d++;
        }
        return true;
    }

    private boolean ok(List<Integer> list, int d) {
        if (d % 2 == 0) {
            int pre = -1;
            for (Integer i : list) {
                if (i % 2 == 0 || i <= pre) return false;
                pre = i;
            }
        }
        else {
            int pre = 0x3f3f3f3f;
            for (Integer i : list) {
                if (i % 2 == 1 || i >= pre) return false;
                pre = i;
            }
        }
        return true;

    }
}
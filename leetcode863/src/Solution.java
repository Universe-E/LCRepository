import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    ArrayList<Integer>[] g;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        g = new ArrayList[501];
        Arrays.setAll(g,e -> new ArrayList<>());
        var q = new ArrayDeque<TreeNode>();
        q.addLast(root);
        // build graph
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                var p = q.pollFirst();
                assert p != null;
                if (p.left != null) {
                    g[p.val].add(p.left.val);
                    g[p.left.val].add(p.val);
                    q.addLast(p.left);
                }
                if (p.right != null) {
                    g[p.val].add(p.right.val);
                    g[p.right.val].add(p.val);
                    q.addLast(p.right);
                }
            }
        }
        boolean[] v = new boolean[501];
        var q2 = new ArrayDeque<Integer>();
        q2.addLast(target.val);
        v[target.val] = true;
        while (k > 0) {
            int sz = q2.size();
            for (int i = 0; i < sz; i++) {
                int x = q2.pollFirst();
                for (Integer y : g[x]) {
                    if (v[y]) continue;
                    q2.addLast(y);
                    v[y] = true;
                }
            }
            k--;
        }
        return new ArrayList<>(q2);
    }
}
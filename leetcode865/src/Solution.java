import java.util.Objects;

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
    class Pair<E,V> {
        E e;
        V v;
        public Pair(E e,V v) {
            this.e = e;
            this.v = v;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).e;
    }

    private Pair<TreeNode,Integer> dfs(TreeNode root) {
        if (root == null) return new Pair<>(root,0);
        var lp = dfs(root.left);
        var rp = dfs(root.right);
        if (lp.v.equals(rp.v)) return new Pair<>(root,lp.v+1);
        return lp.v > rp.v ? new Pair<>(lp.e,lp.v+1) : new Pair<>(rp.e,rp.v+1);
    }
}
import java.util.*;

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
    int d = 0;
    //map stores every father node of each node
    HashMap<TreeNode,TreeNode> map = new HashMap<>();
    HashMap<Integer, HashSet<TreeNode>> dmap = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,0,null);
        HashSet<TreeNode> set = dmap.get(d);
        int sz = set.size();
        while (sz > 1) {
            HashSet<TreeNode> temp = new HashSet<>();
            for (TreeNode node : set) {
                temp.add(map.get(node));
            }
            set = temp;
            sz = set.size();
        }
        for (TreeNode treeNode : set) {
            return treeNode;
        }
        return null;
    }

    private void dfs(TreeNode node, int depth, TreeNode pre) {
        if (node == null) return;
        map.put(node,pre);
        dmap.computeIfAbsent(depth,k->new HashSet<>()).add(node);
        d = Math.max(d,depth);
        dfs(node.left,depth+1,node);
        dfs(node.right,depth+1,node);
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

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return f(root).e;
    }

    private Pair<TreeNode, Integer> f(TreeNode root) {
        if (root == null) {
            return new Pair<>(root, 0);
        }

        Pair<TreeNode, Integer> left = f(root.left);
        Pair<TreeNode, Integer> right = f(root.right);

        if (left.v > right.v) {
            return new Pair<>(left.e, left.v + 1);
        }
        if (left.v < right.v) {
            return new Pair<>(right.e, right.v + 1);
        }
        return new Pair<>(root, left.v + 1);
    }
}
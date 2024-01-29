import java.util.ArrayDeque;
import java.util.HashMap;

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
    HashMap<Integer,int[]> map;
    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        dfs(root,-1);
        HashMap<Integer,Boolean> v = new HashMap<>();
        for (Integer k : map.keySet()) {
            v.put(k,false);
        }
        int res = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(start);
        v.put(start,true);
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean added = false;
            for (int i = 0; i < sz; i++) {
                assert !q.isEmpty();
                int x = q.pollFirst();
                int[] arr = map.get(x);
                for (int y : arr) {
                    if (y == -1) continue;
                    if (v.get(y)) continue;
                    q.addLast(y);
                    added = true;
                    v.put(y,true);
                }
            }
            if (added) res++;
        }
        return res;
    }

    private void dfs(TreeNode node, int fa) {
        if (node == null) return;
        map.put(node.val,new int[]{fa,node.left == null ? -1 : node.left.val,node.right == null ? -1 : node.right.val});
        dfs(node.left,node.val);
        dfs(node.right,node.val);
    }
}
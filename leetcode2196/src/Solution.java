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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashMap<Integer,Integer> fa = new HashMap<>();
        for (int[] d : descriptions) {
            int p = d[0],c = d[1],isL = d[2];

            TreeNode cur = map.getOrDefault(p,new TreeNode(p));
            TreeNode child = map.getOrDefault(c,new TreeNode(c));

            if (isL == 1) cur.left = child;
            else cur.right = child;

            map.put(p,cur);
            map.put(c,child);
            fa.put(c,p);

        }
        for (Integer k : map.keySet()) {
            if (fa.get(k) == null) return map.get(k);
        }
        return null;
    }
}
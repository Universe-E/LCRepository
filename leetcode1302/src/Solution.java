import java.util.Collections;
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
    HashMap<Integer, Integer> map = new HashMap<>();
    public int deepestLeavesSum(TreeNode root) {
        inOrder(root,1);
        int res = 0;
        for (Integer i : map.keySet()) res = Math.max(res, i);
        return map.get(res);
    }

    private void inOrder(TreeNode root,int depth) {
        if (root == null) return;
        inOrder(root.left,depth + 1);
        if (!map.containsKey(depth)) map.put(depth, root.val);
        else map.put(depth, map.get(depth) + root.val);
        inOrder(root.right,depth + 1);
    }
}

//深度优先遍历
class Solution2 {
    int maxDepth = 0, sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,1);
        return sum;
    }

    private void dfs(TreeNode root,int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            sum = root.val;
        }
        else if(depth == maxDepth) sum += root.val;
        dfs(root.left,depth + 1);
        dfs(root.right, depth + 1);
    }
}
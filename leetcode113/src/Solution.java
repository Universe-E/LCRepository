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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) dfs(root,0,targetSum);
        return res;
    }

    private void dfs(TreeNode root, int sum, int targetSum) {
        if (root.left == null && root.right == null) {
            sum += root.val;
            cur.add(root.val);
            if (sum == targetSum) res.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        if (root.left != null) {
            cur.add(root.val);
            dfs(root.left,sum + root.val,targetSum);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            cur.add(root.val);
            dfs(root.right, sum + root.val, targetSum);
            cur.remove(cur.size() - 1);
        }
    }
}
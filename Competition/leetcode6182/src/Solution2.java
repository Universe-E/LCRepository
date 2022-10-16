public class Solution2 {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left,root.right,1);
        return root;
    }

    private void dfs(TreeNode left,TreeNode right,int depth) {
        if (left == null || right == null) return;
        if (depth % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        dfs(left.left,right.right,depth + 1);
        dfs(left.right,right.left,depth + 1);
    }
}

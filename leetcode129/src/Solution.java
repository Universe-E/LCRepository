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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,new StringBuilder().append(root.val));
        return sum;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString());
            return;
        }
        if (root.left != null) {
            sb.append(root.left.val);
            dfs(root.left,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (root.right != null) {
            sb.append(root.right.val);
            dfs(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
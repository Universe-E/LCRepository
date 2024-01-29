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
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,new int[10], 0);
        return res;
    }

    private void dfs(TreeNode root, int[] cnt, int sz) {
        if (root == null) return;
        cnt[root.val]++;
        sz++;
        //leaf
        if (root.left == null && root.right == null) {
            int odd = 0;
            for (int i = 1; i <= 9; i++) {
                if (cnt[i] % 2 != 0) odd++;
            }
            if (sz % 2 == 0 && odd == 0) res++;
            else if (sz % 2 != 0 && odd == 1) res++;
        }
        dfs(root.left,cnt, sz);
        dfs(root.right,cnt, sz);
        cnt[root.val]--;
    }

}
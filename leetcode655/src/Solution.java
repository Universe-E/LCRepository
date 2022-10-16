import java.util.ArrayList;
import java.util.Arrays;
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
    int treeHeight = 0, n = 0;

    public List<List<String>> printTree(TreeNode root) {
        treeHeight = getHeight(root) - 1;
        n = (int) (Math.pow(2, treeHeight + 1) - 1);
        String[][] res = new String[treeHeight + 1][n];
        for (String[] re : res) {
            Arrays.fill(re, "");
        }
        dfs(root,0,(n - 1) / 2,res);
        List<List<String>> resList = new ArrayList<>();
        for (String[] re : res) {
            List<String> curList = new ArrayList<>(Arrays.asList(re));
            resList.add(curList);
        }
        return resList;
    }

    private void dfs(TreeNode root,int height,int c,String[][] res) {
        if (root == null) return;
        dfs(root.left,height + 1,c - (int)(Math.pow(2,treeHeight - height - 1)),res);
        dfs(root.right,height + 1,c + (int)(Math.pow(2,treeHeight - height - 1)),res);
        res[height][c] = String.valueOf(root.val);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.max(l,r) + 1;
    }


}

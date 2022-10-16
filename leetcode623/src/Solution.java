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
    private boolean isLeft = true;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            if (isLeft) newRoot.left = root;
            else newRoot.right = root;
            return newRoot;
        }
        else if (root != null){
            isLeft = true;
            root.left = addOneRow(root.left,val,depth - 1);
            isLeft = false;
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }
}

class Solution2 {
    private int level;

    private void dfs(TreeNode root, int val, int depth) {
        if (root == null) return;
        if (depth == level - 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val,left,null);
            root.right = new TreeNode(val, null, right);
            return;
        }
        dfs(root.left,val,depth + 1);
        dfs(root.right, val, depth + 1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth){
        if (depth == 1) return new TreeNode(val,root,null);
        level = depth;
        dfs(root,val,1);
        return root;
    }
}

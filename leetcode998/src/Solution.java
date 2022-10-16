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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) return new TreeNode(val,root,null);
                else {
                    parent.right = new TreeNode(val,cur,null);
                    return root;
                }
            }
            else {
                parent = cur;
                cur = cur.right;
            }
        }
        //如果找到最后依然没有到达，则直接挂接到parent右节点
        if (parent != null) parent.right = new TreeNode(val);
        return root;
    }
}
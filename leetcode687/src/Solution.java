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
    public int longestUnivaluePath(TreeNode root) {
        findLongest(root,root == null ? 0 : root.val);
        return res;
    }

    private int findLongest(TreeNode cur,int rootVal) {
        if (cur == null) return 0;
        int l = findLongest(cur.left, cur.val);
        int r = findLongest(cur.right, cur.val);
        res = Math.max(res, l + r);
        //如果当前节点的值（cur.val）和父节点的值（rootVal）相等，
        //由于已经得到当前节点左右的最深值，故返回左右最深值的最大值并加一作为父节点的值
        //如果不相等返回0
        if (cur.val == rootVal) {
            return Math.max(l,r) + 1;
        }
        else return 0;
    }
}
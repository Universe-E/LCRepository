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
    int fx = -1,kx = -1,fy = -1,ky = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        preOrder(root,x,y,-1,0);
        return fx != fy && kx == ky;
    }

    private void preOrder(TreeNode root, int x, int y,int fa,int k) {
        if (root == null) return;
        preOrder(root.left,x,y,root.val,k+1);
        preOrder(root.right,x,y,root.val,k+1);
        if (root.val == x) {
            fx = fa;
            kx = k;
        }
        if (root.val == y) {
            fy = fa;
            ky = k;
        }
    }

}
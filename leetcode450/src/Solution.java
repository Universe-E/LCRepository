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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        //find the target
        if (root.val == key) {
            TreeNode l = root.left, r = root.right;
            if (l == null) return r;
            if (r == null) return l;
            //add the lRoot to the leftmost of the rRoot, then return rRoot
            TreeNode rl = r;
            while (rl.left != null) rl = rl.left;
            rl.left = l;
            return r;
        }
        //if key is larger than root.val, find the target in the rRoot
        if (key > root.val) root.right = deleteNode(root.right,key);
        //or find the target in the lRoot
        else root.left = deleteNode(root.left,key);
        return root;
    }
}
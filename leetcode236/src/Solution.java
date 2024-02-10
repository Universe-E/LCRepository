class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        //如果都在左边，则从左边开始找
        if (find(root.left,p) && find(root.left,q)) {
            return lowestCommonAncestor(root.left, p,q);
        }
        //如果都在右边，则从右边开始找
        else if (find(root.right,p) && find(root.right,q)) {
            return lowestCommonAncestor(root.right,p,q);
        }
        //否则代表p和q分列两侧，此时直接返回root
        else return root;
    }

    private boolean find(TreeNode root,TreeNode node) {
        if (root == null) return false;
        if (root.val == node.val) return true;
        //分别找root.left和root.right
        return find(root.left,node) || find(root.right,node);
    }
}

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode l = lowestCommonAncestor(root.left, p,q);
        TreeNode r = lowestCommonAncestor(root.right, p,q);
        //左侧没有目标值
        if (l == null) return r;
        //右侧没有目标值
        if (r == null) return l;
        //l和r分列两侧
        return root;
    }
}
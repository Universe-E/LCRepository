class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果其中一个节点的值和root相等，则该节点即为公共祖先
        if (p.val == root.val || q.val == root.val) return root;
        //如果两节点的值同时小于（大于）root，则到左子树（右子树）去找
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        //如果都不满足，说明节点的值分别位于root两侧，该节点即为公共祖先
        return root;
    }
}

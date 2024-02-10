import java.util.ArrayDeque;

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
    public TreeNode replaceValueInTree(TreeNode root) {
        var q = new ArrayDeque<TreeNode>();
        q.addLast(root);
        root.val = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            TreeNode[] ts = new TreeNode[sz];
            int nextSum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.pollFirst();
                assert cur != null;
                if (cur.left != null) {
                    nextSum += cur.left.val;
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    nextSum += cur.right.val;
                    q.addLast(cur.right);
                }
                ts[i] = cur;
            }
            for (TreeNode t : ts) {
                int nextNeighborSum = (t.left != null ? t.left.val :0) + (t.right != null ? t.right.val : 0);
                if (t.left != null) t.left.val = nextSum - nextNeighborSum;
                if (t.right != null) t.right.val = nextSum - nextNeighborSum;
            }
        }
        return root;
    }
}
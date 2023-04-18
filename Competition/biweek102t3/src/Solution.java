import java.util.ArrayDeque;
import java.util.ArrayList;

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
    int[] sum = new int[100005];
    public TreeNode replaceValueInTree(TreeNode root) {
        dfs(root,0);
        work(root,0,0);
        return root;
    }

    private void dfs(TreeNode node,int d) {
        if (node == null) return;
        sum[d] += node.val;
        if (node.left != null) dfs(node.left,d+1);
        if (node.right != null) dfs(node.right,d+1);
    }

    private void work(TreeNode root,int d,int neighbor) {
        if (root == null) return;
        root.val = sum[d]-root.val-neighbor;
        int lt = root.left == null ? 0 : root.left.val;
        int rt = root.right == null ? 0 : root.right.val;
        work(root.left,d+1,rt);
        work(root.right,d+1,lt);
    }

}

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        root.val = 0;
        q.add(root);
        //每次层序遍历，都原地修改下一层的节点值
        while (!q.isEmpty()) {
            int n = q.size(),sum = 0;
            TreeNode[] ts = new TreeNode[n];
            //一次遍历，把下一层的节点先存起来
            for (int i = 0; i < n; i++) {
                TreeNode t = q.pollFirst();
                ts[i] = t;
                if (t.left != null) {
                    sum += t.left.val;
                    q.addLast(t.left);
                }
                if (t.right != null) {
                    sum += t.right.val;
                    q.addLast(t.right);
                }
            }
            //二次遍历，修改下一层节点的值
            for (TreeNode t : ts) {
                int neighbors = 0;
                if (t.left != null) neighbors += t.left.val;
                if (t.right != null) neighbors += t.right.val;
                if (t.left != null) t.left.val = sum-neighbors;
                if (t.right != null) t.right.val = sum-neighbors;
            }
        }
        return root;
    }
}
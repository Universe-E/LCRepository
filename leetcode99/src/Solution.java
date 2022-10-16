import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public void recoverTree(TreeNode root) {
        inOrder(root);
        putValByInOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        pq.add(root.val);
        inOrder(root.right);
    }

    private void putValByInOrder(TreeNode root) {
        if (root == null) return;
        putValByInOrder(root.left);
        root.val = pq.poll();
        putValByInOrder(root.right);
    }
}

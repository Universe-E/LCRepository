import java.util.ArrayList;
import java.util.List;

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
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        if (node.left != null) preorderTraversal(node.left);
        if (node.right != null) preorderTraversal(node.right);
    }
}
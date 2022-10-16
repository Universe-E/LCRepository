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
    public boolean isSymmetric(TreeNode root) {
        int depth = 0;
        leftOrder(root.left,depth);
        rightOrder(root.right,depth);
        return leftList.equals(rightList) && leftDepth.equals(rightDepth);
    }

    List<Integer> leftList = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    List<Integer> leftDepth = new ArrayList<>();
    List<Integer> rightDepth = new ArrayList<>();

    //左中序遍历，同时记录深度
    private void leftOrder(TreeNode node,int depth) {
        //如果没有节点，直接加-101
        if (node == null) {
            leftList.add(-101);
            leftDepth.add(depth);
            return;
        }
        if (!isLeaf(node)) {
            depth++;
            leftOrder(node.left,depth);
        }
        leftList.add(node.val);
        leftDepth.add(depth);
        if (!isLeaf(node)) {
            depth++;
            leftOrder(node.right,depth);
        }
    }

    //右中序遍历
    private void rightOrder(TreeNode node,int depth) {
        if (node == null) {
            rightList.add(-101);
            rightDepth.add(depth);
            return;
        }
        if (!isLeaf(node)) {
            depth++;
            rightOrder(node.right,depth);
        }
        rightList.add(node.val);
        rightDepth.add(depth);
        if (!isLeaf(node)) {
            depth++;
            rightOrder(node.left,depth);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

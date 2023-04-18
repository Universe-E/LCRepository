import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
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
    List<TreeNode> res = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) {
            set.add(i);
        }
        preOrder(root);
        //注意要单独处理根节点，该节点无法返回上一层，因此若不需要删除，则加入list中
        if (!set.contains(root.val)) res.add(root);
        return res;
    }

    //返回当前节点是否要删除
    private boolean preOrder(TreeNode root) {
        if (root == null) return false;
        //如果子节点返回true，则在当前层删除该子节点
        if (preOrder(root.left)) root.left = null;
        if (preOrder(root.right)) root.right = null;
        //处理需要删除的情况
        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return true;
        }
        return false;
    }
}
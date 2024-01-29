import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
    List<Integer> l1,l2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        l1 = new ArrayList<>();
        l2 = new ArrayList<>();
        inOrder(root1,1);
        inOrder(root2,2);
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!Objects.equals(l1.get(i), l2.get(i))) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root, int i) {
        if (root == null) return;
        inOrder(root.left,i);
        if (root.left == null && root.right == null) {
            if (i == 1) l1.add(root.val);
            else l2.add(root.val);
        }
        inOrder(root.right,i);
    }
}
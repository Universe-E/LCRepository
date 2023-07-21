import java.util.ArrayList;
import java.util.Arrays;
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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n%2 == 0) return res;
        if (n == 1) return List.of(new TreeNode(0));
        for (int i = 1; i < n-1; i+=2) {
            List<TreeNode> l = allPossibleFBT(i);
            List<TreeNode> r = allPossibleFBT(n-i-1);
            for (TreeNode lt : l) {
                for (TreeNode rt : r) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = lt;
                    cur.right = rt;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
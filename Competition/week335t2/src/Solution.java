import javafx.util.Pair;

import java.util.ArrayDeque;
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Long[] res = new Long[100005];
        Arrays.fill(res, 0L);
        ArrayDeque<Pair<TreeNode,Integer>> d = new ArrayDeque<>();
        d.add(new Pair<>(root,0));
        while (!d.isEmpty()) {
            Pair<TreeNode, Integer> p = d.pollFirst();
            TreeNode t = p.getKey();
            int v = t.val, i = p.getValue();
            res[i] += v;
            if (t.left != null) d.addLast(new Pair<>(t.left,i+1));
            if (t.right != null) d.addLast(new Pair<>(t.right, i+1));
        }
        Arrays.sort(res,(o1,o2) -> ((o2-o1) > 0 ? 1 : (o2.equals(o1)) ? 0 : -1));
        return res[k-1]==0 ? -1 : res[k-1];
    }
}
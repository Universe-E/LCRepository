import java.util.*;

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
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        List<Integer> lefts = new LinkedList<>();
        countDepth(root.left, 0, lefts);
        List<Integer> rights = new LinkedList<>();
        countDepth(root.right, 0, rights);

        int res = 0;
        for (Integer l : lefts)
            for (Integer r : rights)
                if (l + r + 2 <= distance)
                    res++;

        res += countPairs(root.left, distance);
        res += countPairs(root.right, distance);
        return res;
    }

    void countDepth(TreeNode node, int depth, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(depth);
            return;
        }
        countDepth(node.left, depth + 1, list);
        countDepth(node.right, depth + 1, list);
    }
}
import javafx.util.Pair;

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
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<Pair<TreeNode,Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(root,1));
        int res = 0, curDepth = 0;
        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> pair = deque.pollFirst();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            //find the deepest element and renew the left value
            if (depth > curDepth) {
                curDepth = depth;
                res = node.val;
            }
            if (node.left != null) deque.addLast(new Pair<>(node.left,depth+1));
            if (node.right != null) deque.addLast(new Pair<>(node.right, depth+1));
        }
        return res;
    }
}

class Solution2 {
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        //add the right child first, the leftmost value is the last element
        while (!deque.isEmpty()) {
            root = deque.pollFirst();
            if (root.right != null) deque.addLast(root.right);
            if (root.left != null) deque.addLast(root.left);
        }
        return root.val;
    }
}
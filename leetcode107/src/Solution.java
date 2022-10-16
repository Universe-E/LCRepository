import java.util.ArrayDeque;
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
    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> temp = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
                cur.add(node.val);
            }
            temp.add(cur);
        }
        while (!temp.isEmpty()) {
            res.add(temp.remove(temp.size() - 1));
        }
        return res;
    }
}
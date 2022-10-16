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

//双端队列
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean R = true;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = R ? deque.pollFirst() : deque.pollLast();
                if (R) {
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }
                else {
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                cur.add(node.val);
            }
            res.add(cur);
            R = !R;
        }
        return res;
    }
}
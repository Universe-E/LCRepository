import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> curList = new ArrayList<>();
            while (count != 0) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    curList.add(curNode.val);
                    if (curNode.left != null) queue.add(curNode.left);
                    if (curNode.right != null) queue.add(curNode.right);
                }
                count--;
            }
            resList.add(curList);
        }
        return resList;
    }
}

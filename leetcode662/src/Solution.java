import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1[1] == o2[1]) return o1[0] - o2[0];
        return o1[1] - o2[1];
    });

    public int widthOfBinaryTree(TreeNode root) {
        preOrderIndex(root,1,1);
        int res = 0;
        while (!pq.isEmpty()) {
            int depth = pq.peek()[1];
            int first = pq.peek()[0], last = first;
            while (!pq.isEmpty() && pq.peek()[1] == depth) {
                last = pq.poll()[0];
            }
            res = Math.max(res, last - first + 1);
        }
        return res;
    }

    private void preOrderIndex(TreeNode node,int index,int depth) {
        if (node == null) return;
        pq.add(new int[] {index,depth});
        preOrderIndex(node.left,2 * index,depth + 1);
        preOrderIndex(node.right, 2 * index + 1,depth + 1);
    }
}

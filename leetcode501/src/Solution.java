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
    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Integer key : map.keySet()) {
            pq.add(new int[] {key,map.get(key)});
        }
        int temp = pq.peek()[1];
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty() && pq.peek()[1] == temp) {
            list.add(pq.poll()[0]);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (!map.containsKey(root.val)) map.put(root.val, 1);
        else map.put(root.val,map.get(root.val) + 1);
        inOrder(root.right);
    }
}

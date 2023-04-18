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
    ArrayDeque<int[]> stack = new ArrayDeque<>();
    ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
    TreeNode node;
    public TreeNode recoverFromPreorder(String traversal) {
        int len = traversal.length();
        int depth = 0,cur = 0;
        for (int i = 0; i < len; i++) {
            char c = traversal.charAt(i);
            if (c == '-') {
                if (cur != 0) {
                    build(cur,depth);
                    cur = 0;
                    depth = 0;
                }
                depth++;
            } else {
                cur = cur * 10 + c - '0';
                if (i == len - 1) build(cur,depth);
            }
        }
        return nodes.peekLast();
    }
    private void build(int cur,int depth) {
        while (!stack.isEmpty() && depth <= stack.peek()[1]) {
            stack.pop();
            nodes.pop();
        }
        if (node == null) {
            node = new TreeNode(cur);
        }
        else {
            node = nodes.peek();
            if (node.left == null) {
                node.left = new TreeNode(cur);
                node = node.left;
            }
            else {
                node.right = new TreeNode(cur);
                node = node.right;
            }
        }
        stack.push(new int[] {cur,depth});
        nodes.push(node);
    }
}
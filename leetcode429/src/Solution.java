import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) q.addLast(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = q.pollFirst();
                assert node != null;
                cur.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    q.addLast(node.children.get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }
}
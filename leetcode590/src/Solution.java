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
}


class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        post(root);
        return res;
    }

    private void post(Node node) {
        if (node == null) return;
        for (Node child : node.children) {
            post(child);
        }
        res.add(node.val);
    }
}
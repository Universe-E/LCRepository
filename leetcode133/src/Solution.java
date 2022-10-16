import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    Node[] visited = new Node[101];
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        int size = node.neighbors.size();
        Node root = new Node(node.val,new ArrayList<>());
        visited[node.val] = root;
        for (int i = 0; i < size; i++) {
            if (visited[node.neighbors.get(i).val] == null) {
                root.neighbors.add(cloneGraph(node.neighbors.get(i)));
            }
            else {
                root.neighbors.add(visited[node.neighbors.get(i).val]);
            }
        }
        return root;
    }
}
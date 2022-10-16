import java.util.ArrayDeque;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution {
    public Node connect(Node root) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                if (i == size - 1) node.next = null;
                else node.next = deque.peek();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return root;
    }
}

class Solution2 {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            //如果当前root不是最后一个节点，则让它的右子节点.next等于下一个节点的左子节点
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

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
        if (root == null) return null;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            }
            else {
                if (root.next == null) root.left.next = null;
                else {
                    Node cur = root.next;
                    //直到找到有子节点的根节点，如果都没有子节点，则找到末尾节点
                    while (cur.next != null && cur.left == null && cur.right == null) cur = cur.next;
                    root.left.next = cur.left != null ? cur.left : cur.right;
                }
            }
        }
        if (root.right != null) {
            if (root.next == null) root.right.next = null;
            else {
                Node cur = root.next;
                while (cur.next != null && cur.left == null && cur.right == null) cur = cur.next;
                root.right.next = cur.left != null ? cur.left : cur.right;
            }
        }
        //注意！要先递归构建右子树，如果先递归左子树，右侧的next没有建立完整，导致中间断线
        connect(root.right);
        connect(root.left);
        return root;
    }
}

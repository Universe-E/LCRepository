class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}


class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node root = new Node(insertVal);
            root.next = root;
            return root;
        }
        Node cur = head,after = cur.next;
        int max = cur.val, min = cur.val,cnt = 0;
        boolean hasTail = false;
        while (true) {
            if (after.val < cur.val) {
                max = cur.val;
                min = after.val;
                hasTail = true;
            }
            cur = cur.next;
            after = after.next;
            if (insertVal >= cur.val && insertVal <= after.val) {
                Node node = new Node(insertVal);
                cur.next = node;
                node.next = after;
                return head;
            }
            //tail exists and find the tail
            if (hasTail && cur.val == max && after.val == min) {
                if (insertVal >= max || insertVal <= min) {
                    Node node = new Node(insertVal);
                    cur.next = node;
                    node.next = after;
                    return head;
                }
            }
            cnt++;
            //all the node.val must be the same
            if (cnt > 50005) {
                Node node = new Node(insertVal);
                cur.next = node;
                node.next = after;
                return head;
            }
        }
    }
}
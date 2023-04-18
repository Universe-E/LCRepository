class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node cNode = cur.child;
            if (cNode != null) {
                if (cur.next != null) {
                    Node cTail = getTail(cNode);
                    Node n = cur.next;
                    cTail.next = n;
                    n.prev = cTail;
                }
                cur.next = cNode;
                cNode.prev = cur;
                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }

    private Node getTail(Node head) {
        if (head == null) return null;
        while (head.next != null) head = head.next;
        return head;
    }
}
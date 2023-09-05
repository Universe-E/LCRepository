import java.util.HashMap;
import java.util.Objects;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node res = new Node(head.val);
        Node cur = res,ptr = head;
        var map1 = new HashMap<Node,Integer>();
        var map2 = new HashMap<Integer,Node>();
        int id = 0;
        map1.put(ptr,id);
        map2.put(id,cur);
        //Construct basic list node
        while (ptr.next != null) {
            cur.next = new Node(ptr.next.val);
            id++;
            map1.put(ptr.next,id);
            map2.put(id,cur.next);
            ptr = ptr.next;
            cur = cur.next;
        }
        cur = res;
        ptr = head;
        while (ptr != null) {
            if (ptr.random != null) {
                int i = map1.get(ptr.random);
                cur.random = map2.get(i);
            }
            ptr = ptr.next;
            cur = cur.next;
        }
        return res;
    }
}
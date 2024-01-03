import java.util.ArrayDeque;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = list.size()-1,num = -1; i >= 0; i--) {
            int curNum = list.get(i);
            if (curNum >= num) {
                q.addFirst(curNum);
                num = curNum;
            }
        }
        if (q.isEmpty()) return null;
        ListNode newHead = new ListNode(q.pollFirst());
        cur = newHead;
        while (!q.isEmpty()) {
            cur.next = new ListNode(q.pollFirst());
            cur = cur.next;
        }
        return newHead;
    }
}

class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val) return head.next;
        else return head;
    }
}
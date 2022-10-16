import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) values[i] = list.get(i);
        ListNode dummy = new ListNode(0),cur2 = dummy;
        for (int value : values) {
            cur2.next = new ListNode(value);
            cur2 = cur2.next;
        }
        return dummy.next;
    }
}

class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head,fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rhead = slow.next,after = rhead;
        while (after != null) {
            after = after.next;
        }
        //现在让中点处断开
        slow.next = null;
        head = sortList(head);
        rhead = sortList(rhead);
        return merge(head,rhead);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0),cur = dummy;
        while (l != null || r != null) {
            if (l == null) {
                cur.next = new ListNode(r.val);
                r = r.next;
            }
            else if (r == null) {
                cur.next = new ListNode(l.val);
                l = l.next;
            }
            else if (l.val <= r.val) {
                cur.next = new ListNode(l.val);
                l = l.next;
            }
            else {
                cur.next = new ListNode(r.val);
                r = r.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

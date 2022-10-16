class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        //将后一半链表翻转，然后逐个插入挂接
        ListNode dummy2 = new ListNode(0);
        ListNode cur2 = dummy2.next;
        while (head2 != null) {
            ListNode newRev = new ListNode(head2.val);
            newRev.next = cur2;
            cur2 = newRev;
            dummy2.next = cur2;
            head2 = head2.next;
        }
        ListNode cur = dummy2.next,tail = head;

        while (cur != null) {
            ListNode newRev = new ListNode(cur.val);
            newRev.next = tail.next;
            tail.next = newRev;
            tail = newRev.next;
            cur = cur.next;
        }
    }
}

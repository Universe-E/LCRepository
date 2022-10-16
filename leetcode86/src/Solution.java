class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE,head);
        ListNode dummy2 = new ListNode(Integer.MIN_VALUE,head);
        ListNode cur = dummy,tail = head;
        ListNode cur2 = dummy2;
        while (tail != null) {
            if (tail.val < x) {
                cur.next = tail;
                cur = cur.next;
            }
            else {
                cur2.next = tail;
                cur2 = cur2.next;
            }
            tail = tail.next;
        }
        cur.next = null;
        cur2.next = null;
        cur.next = dummy2.next;
        return dummy.next;
    }
}

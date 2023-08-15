class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode dummy2 = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head,less = dummy,more = dummy2;
        while (cur != null) {
            if (cur.val < x) {
                less.next = new ListNode(cur.val);
                less = less.next;
            }
            else {
                more.next = new ListNode(cur.val);
                more = more.next;
            }
            cur = cur.next;
        }
        less.next = dummy2.next;
        return dummy.next;
    }
}

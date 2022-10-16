class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0,head),dummy2 = new ListNode(0);
        ListNode cur = dummy.next,cur2 = dummy2;
        while (cur.next != null) {
            cur2.next = cur.next;
            cur.next = cur.next.next;
            cur2 = cur2.next;
            cur2.next = null;
            if (cur.next != null) {
                cur = cur.next;
            }
        }
        cur.next = dummy2.next;
        return dummy.next;
    }
}

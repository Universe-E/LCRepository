class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        int len = 0;
        ListNode p0 = dummy;
        while (p0.next != null) {
            p0 = p0.next;
            len++;
        }
        ListNode p1 = dummy,p2 = dummy;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        for (int i = 0; i < len - k + 1; i++) {
            p2 = p2.next;
        }
        int t = p1.val;
        p1.val = p2.val;
        p2.val = t;
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            cur.next = dummy.next;
            dummy.next = cur;
            head = head.next;
        }
        return dummy.next;
    }
}

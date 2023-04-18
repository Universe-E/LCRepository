class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode cur = dummy;
            while (cur.next != null && cur.next.val < head.val) cur = cur.next;
            cur.next = new ListNode(head.val,cur.next);
            head = head.next;
        }
        return dummy.next;
    }
}
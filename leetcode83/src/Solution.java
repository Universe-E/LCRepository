
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head),prev = dummy,cur = prev.next;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                prev.next = cur;
            }
            prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode after = head.next;
        head.next = swapPairs(after.next);
        after.next = head;
        return after;
    }
}

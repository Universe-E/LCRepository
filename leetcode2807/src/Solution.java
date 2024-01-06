class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode insert = new ListNode(gcd(head.val,head.next.val));
        insert.next = insertGreatestCommonDivisors(head.next);
        head.next = insert;
        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b,a%b);
    }
}
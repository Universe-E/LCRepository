class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int numberEvenListNode(ListNode head) {
        int res = 0;
        while (head != null) {
            if (head.val % 2 == 1) res++;
            head = head.next;
        }
        return res;
    }
}
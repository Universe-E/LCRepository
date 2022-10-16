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
        //单数个尾结点不作任何交换，直接返回
        if (head.next == null) return head;
        ListNode nextOne = head.next;
        head.next = swapPairs(head.next.next);
        nextOne.next = head;
        return nextOne;
    }
}

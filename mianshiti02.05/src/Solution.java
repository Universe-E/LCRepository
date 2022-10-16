class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode dummy = new ListNode(0),head = dummy;
        while (l1 != null && l2 != null) {
            int value = (l1.val + l2.val + up) % 10;
            up = (l1.val + l2.val + up) / 10;
            head.next = new ListNode(value);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //如果有剩余，继续运算
        ListNode remains = l1 != null ? l1 : l2;
        while (remains != null) {
            int value = (remains.val + up) % 10;
            up = (remains.val + up) / 10;
            head.next = new ListNode(value);
            head = head.next;
            remains = remains.next;
        }
        //注意最后一位可能会进位
        if (up != 0) head.next = new ListNode(up);
        return dummy.next;
    }
}
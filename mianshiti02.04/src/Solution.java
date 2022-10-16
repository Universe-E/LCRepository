class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//经典穿针引线法
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(-101),rightDummy = new ListNode(-101);
        ListNode left = leftDummy,right = rightDummy;
        while (head != null) {
            if (head.val < x) {
                left.next = new ListNode(head.val);
                left = left.next;
            }
            else {
                right.next = new ListNode(head.val);
                right = right.next;
            }
            head = head.next;
        }
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}
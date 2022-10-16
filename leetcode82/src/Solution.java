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
        if (cur == null) return null;
        while (cur != null && cur.next != null) {
            boolean isSkipped = false;
            //如果有相等的值，则找到其最后一个节点
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                if (cur.next == null || cur.val != cur.next.val) {
                    prev.next = cur.next;
                    cur = prev.next;
                    isSkipped = true;
                }
            }
            //如果已经跳过一次，就不再继续前进
            if (!isSkipped) {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

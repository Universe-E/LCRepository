class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode p = dummy, q = p.next;
        //从虚拟头结点开始，找到间隔n个节点的两个节点，由于n<=sz，不必担心空指针
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        //一直遍历到末尾，此时p指向的即是待删除的节点
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}

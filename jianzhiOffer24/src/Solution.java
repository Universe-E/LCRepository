class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        //0-1个节点直接返回
        if (head == null || head.next == null) return head;
        //声明3个节点
        ListNode prev = null,cur = head;
        //如果有2个节点直接做翻转操作
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
    }
}

class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            cur.next = dummy.next;
            dummy.next = cur;
            head = head.next;
        }
        return dummy.next;
    }
}

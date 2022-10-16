

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode tail = head,cur = head;
        int x = 1;//声明链表长度
        while (tail.next != null) {
            tail = tail.next;
            x++;
        }
        if (n == 1) {
            ListNode res = cur;
            for (int i = 0; i < x - 2; i++) cur = cur.next;
            cur.next = null;
            return res;
        }
        else if (n == x) {
            ListNode res = cur.next;
            cur.next = null;
            return res;
        }
        else {
            ListNode res = cur;
            for (int i = 0; i < x - n - 1; i++) cur = cur.next;
            cur.next = cur.next.next;
            return res;
        }
    }


}

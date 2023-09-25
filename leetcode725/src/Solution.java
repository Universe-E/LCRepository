import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        //res[i]是浅拷贝，所以后续的链表操作会影响前面每个res[i]，不用担心
        int big = n%k;
        ListNode[] res = new ListNode[k];
        cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int len = n/k + (i<big ? 1 : 0);
            for (int j = 1; j < len; j++) {
                cur = cur.next;
            }
            //这里断开
            ListNode head2 = cur.next;
            cur.next = null;
            cur = head2;
        }
        return res;
    }
}
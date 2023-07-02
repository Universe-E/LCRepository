import java.util.ArrayDeque;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var q1 = new ArrayDeque<Integer>();
        var q2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            q1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            q2.addLast(l2.val);
            l2 = l2.next;
        }
        int add = 0;
        ListNode res = null;
        while (!q1.isEmpty() || !q2.isEmpty() || add != 0) {
            int t1 = q1.isEmpty() ? 0 : q1.pollLast();
            int t2 = q2.isEmpty() ? 0 : q2.pollLast();
            int val = t1+t2+add;
            add = val/10;
            val %= 10;
            //尾接法
            ListNode cur = new ListNode(val);
            cur.next = res;
            res = cur;
        }
        return res;
    }
}
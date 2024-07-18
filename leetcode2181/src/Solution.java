import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1),cur = dummy;
        int sum = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                cur.next = new ListNode(sum);
                sum = 0;
                cur = cur.next;
            }
            else {
                sum += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
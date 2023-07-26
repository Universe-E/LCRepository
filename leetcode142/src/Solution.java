import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visitedSet = new HashSet<>();
        while (head != null) {
            if (visitedSet.contains(head)) return head;
            visitedSet.add(head);
            head = head.next;
        }
        return null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode slow = head,fast = head,meet = head;
        boolean cycle = false;
        //while hasFast
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                meet = slow;
                break;
            }
        }
        if (!cycle) return null;
        ListNode start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }
        return start;
    }
}
import java.util.HashSet;
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

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    //用快慢指针法， 如果快慢指针相遇说明有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast.next == null || fast.next.next == null) return false;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }
}

public class Solution {
    //用快慢指针法， 如果快慢指针相遇说明有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head,fast = head.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
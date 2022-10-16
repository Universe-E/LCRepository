import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        HashMap<Integer, ListNode> map = new HashMap<>();
        int curSum = 0;
        for (ListNode cur = dummy;cur != null;cur = cur.next) {
            curSum += cur.val;
            //注意，如果curSum已经存在，则cur为新的节点
            map.put(curSum,cur);
        }
        curSum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            curSum += cur.val;
            //当前的sum已存在时，直接让其挂接到最新的sum对应节点的下一个节点
            cur.next = map.get(curSum).next;
        }
        return dummy.next;
    }
}

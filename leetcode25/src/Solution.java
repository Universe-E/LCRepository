
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //dummy是整个链表虚拟头结点，dummy0是当前组的"虚拟头结点"
        ListNode dummy = new ListNode(0),dummy0 = dummy;
        while (true) {
            ListNode tail = head,curHead = tail;
            int p = 1;
            while (tail != null && p % k != 0) {
                tail = tail.next;
                p++;
            }
            //得到该组节点之后，分两种情况：
            //1、如果不是剩余节点，则按照反转链表的思路（剑指Offer24），
            //注意反转后将dummy0移动到末尾，以便挂接下一组节点
            //2、如果是剩余节点，则让dummy0直接挂接head即可
            if (tail != null) {
                //在这里让head等于下一组节点的头部，并让tail与其断开
                head = tail.next;
                tail.next = null;
                while (curHead != null) {
                    ListNode after = dummy0.next;
                    ListNode cur = new ListNode(curHead.val);
                    cur.next = after;
                    dummy0.next = cur;
                    curHead = curHead.next;
                }
                while (dummy0.next != null) dummy0 = dummy0.next;
            }
            //全部挂接完之后结束循环
            else {
                dummy0.next = head;
                break;
            }
        }
        return dummy.next;
    }
}

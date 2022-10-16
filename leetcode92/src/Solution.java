class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int front = 1;
        ListNode cur = head,prev = null;//prev是left的前一个节点，如果left为1则prev = null
        while (front < left) {
            prev = cur;
            cur = cur.next;
            front++;
        }
        //接下来对left到right的部分进行反转
        ListNode prev2 = null,tail = cur;//这里记录反转之后的尾节点tail，即反转前的首节点cur
        int count = 0;
        while (count <= right - left) {
            ListNode after = cur.next;
            cur.next = prev2;
            prev2 = cur;
            cur = after;
            count++;
        }
        //最后挂接上尾部的节点
        tail.next = cur;
        //如果prev != null说明不是从第一个节点开始反转，将头部与反转的部分挂接即可
        if (prev != null) prev.next = prev2;
        return prev != null ? head : prev2;
    }
}

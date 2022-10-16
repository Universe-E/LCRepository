
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        //先记录链表长度
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        //声明偏移量，即从尾部取出的节点个数，其值等于k与链表长度取模
        int x = k % length;
        //如果链表长度为1或偏移量为0直接返回
        if (length == 1 || x == 0) return head;
        ListNode p = head;
        //这里先找到切断前的最后一个点
        for (int i = 1; i < length - x; i++) p = p.next;
        //声明tail2是切断后的第一个点
        ListNode tail2 = p.next;
        p.next = null;

        //找到tail2的最后一个节点
        ListNode p2 = tail2;
        while (p2.next != null) p2 = p2.next;
        //将p2与head挂接上，最终返回tail2
        p2.next = head;
        return tail2;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1,start = null,end = null,tail = list2;
        for (int i = 0; i <= b+1; i++,cur = cur.next) {
            if (i == a-1) start = cur;
            if (i == b+1) end = cur;
        }
        while (tail.next != null) tail = tail.next;
        assert start != null;
        start.next = list2;
        tail.next = end;
        return list1;
    }
}
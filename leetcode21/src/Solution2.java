class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}

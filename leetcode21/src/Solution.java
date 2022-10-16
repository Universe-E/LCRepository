class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null && list2 == null) return null;
//        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode head = null;
        ListNode tail = null;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                if (head == null){
                    head = new ListNode(list1.val);
                    tail = head;
                }
                else{
                    tail.next = new ListNode(list1.val);
                    tail = tail.next;
                }
                list1 = list1.next;
            }
            else {
                if (head == null){
                    head = new ListNode(list2.val);
                    tail = head;
                }else {
                    tail.next = new ListNode(list2.val);
                    tail = tail.next;
                }
                list2 = list2.next;
            }
        }
        tail.next = list1 == null ? list2 : list1;
        return head;
    }
}

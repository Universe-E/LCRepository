import java.util.PriorityQueue;

class Solution {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = mergeTwoLists(res, list);
        }
        return res;
    }

    private ListNode mergeTwoLists(ListNode l1,ListNode l2) {
         if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

         ListNode head = new ListNode(0);
         ListNode tail = head;
         ListNode l1Temp = l1, l2Temp = l2;
         //当二者均不为空时，利用合并操作将较小值所在节点逐个挂接到tail上
         while (l1Temp != null && l2Temp != null) {
             if (l1Temp.val < l2Temp.val) {
                 tail.next = l1Temp;
                 l1Temp = l1Temp.next;
             }
             else {
                 tail.next = l2Temp;
                 l2Temp = l2Temp.next;
             }
             //每次挂接完成后，更新一下tail
             tail = tail.next;
         }
         tail.next = l1Temp == null ? l2Temp : l1Temp;
         return head.next;
    }
}

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //这里声明两个节点，如果遍历到尾部没有重合就返回到另一条链表
        ListNode p1 = headA, p2 = headB;
        //这里第一轮遍历后较长的链表返回到较短的链表头部，待较短的链表遍历完后二者剩余长度恰好相等
        //若能相交则直接返回该节点，若不能相交则同时到达null
        while (p1 != p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;

            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p2;


    }
}

class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //先遍历一个链表，然后存到HashSet中
        Set<ListNode> visited = new HashSet<>();
        ListNode temp1 = headB;
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(temp1)) return temp1;
            temp1.next = headB.next;
            headB = headB.next;
            temp1 = temp1.next;
        }
        return null;


    }
}

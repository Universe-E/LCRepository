/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */

class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode tail = null;
        //声明商，所得商会向结果链表下一位进位
        int quotient = 0;
        while (l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + quotient;//链表加和值
            //对于当前节点，余数和上相加值即为该节点的值
            ListNode cur = new ListNode(sum % 10);
            if (res == null) {
                res = cur;
                tail = cur;
            }
            else {
                tail.next = cur;
                tail = tail.next;
            }
            quotient = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //最后，如果l1和l2全都加完了，此时如果仍有进位（quotient只可能为1），则挂接到tail.next上
        if (quotient != 0) tail.next = new ListNode(quotient);
        return res;
    }
}

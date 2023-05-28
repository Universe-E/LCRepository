import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int mx = 0,l = 0,r = list.size()-1;
        while (l < r) {
            mx = Math.max(mx,list.get(l++)+list.get(r--));
        }
        return mx;
    }
}
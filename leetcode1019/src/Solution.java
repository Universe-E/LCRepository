import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        int[] res = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                res[q.pollLast()] = arr[i];
            }
            q.addLast(i);
        }
        return res;
    }
}
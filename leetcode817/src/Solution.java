import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int res = 0;
        while (head != null) {
            if (!list.contains(head.val)) {
                head = head.next;
                continue;
            }
            while (head!= null && list.contains(head.val)) {
                list.remove((Integer) head.val);
                head = head.next;
            }
            res++;
        }
        return res;
    }
}

class Solution2 {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0,cur = 0;
        while (head != null) {
            if (set.contains(head.val)) cur++;
            else {
                if (cur != 0) res++;
                cur = 0;
            }
            head = head.next;
        }
        //注意不要漏掉末尾的组件
        if (cur != 0) res++;
        return res;
    }
}

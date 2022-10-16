class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        //设置快慢指针，先找到链表的重点（slow）
        //prev是slow的前一个节点
        ListNode prev = head,slow = head,fast = head;
        while (fast != null && fast.next != null) {
            if (prev != slow) prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;//让中点之前的链表与slow节点断开
        ListNode nodeRight = slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(nodeRight);
        return root;
    }
}

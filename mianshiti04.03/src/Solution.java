import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        ArrayList<ListNode> list = new ArrayList<>();
        int curDepth = -1;
        ArrayDeque<Pair<TreeNode,Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(tree,0));
        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> pair = deque.pollFirst();
            TreeNode p = pair.getKey();
            Integer depth = pair.getValue();
            if (depth != curDepth) {
                list.add(new ListNode(p.val));
                curDepth = depth;
            }
            else {
                ListNode head = list.get(depth), cur = head;
                while (cur.next != null) cur = cur.next;
                cur.next = new ListNode(p.val);
            }
            if (p.left != null) deque.addLast(new Pair<>(p.left,depth+1));
            if (p.right != null) deque.addLast(new Pair<>(p.right, depth+1));
        }
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
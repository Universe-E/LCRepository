import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private int length;
    private final Random random = new Random();
    private final ListNode node;
    public Solution(ListNode head) {
        node = head;
        while (head != null) {
            head = head.next;
            length++;
        }
    }

    public int getRandom() {
        int count = random.nextInt(length);
        int i = 0;
        ListNode cur = node;
        while (i < count) {
            cur = cur.next;
            i++;
        }
        return cur.val;
    }
}

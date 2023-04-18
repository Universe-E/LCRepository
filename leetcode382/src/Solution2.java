import java.util.Random;

class Solution {

    private ListNode head;
    private Random rnd;
    public Solution(ListNode head) {
        this.head = head;
        rnd = new Random();
    }

    //蓄水池抽样，对于数据流，随机抽取索引j使得j == 0，此时用res替换cur.val即可
    public int getRandom() {
        int res = head.val,index = 1;
        for (ListNode cur = head.next;cur != null; cur = cur.next, index++) {
            int j = rnd.nextInt(index+1);
            if (j == 0) res = cur.val;
        }
        return res;
    }
}
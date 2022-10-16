import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                //这里当o1的值小于o2的值时，返回值小于0，默认o2的权重大，所以排序为权重由小到大：o1->o2
                return o1.val - o2.val;
            }
        });

        //跳过空链表，按照list.val由小到大添加到优先队列中
        for (ListNode list : lists) {
            if (list == null) continue;
            pq.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            //取出优先队列中的最小值所在节点并暂存到listTemp中
            ListNode listTemp = pq.poll();
            tail.next = listTemp;
            tail = tail.next;
            //只要当前节点下一个不为空，则更新当前节点，并在此添加到优先队列中去
            if (listTemp.next != null) {
                listTemp = listTemp.next;
                pq.add(listTemp);
            }
        }
        return head.next;
    }


}

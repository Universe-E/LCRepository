import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static final int M = (int)(1e9+7);
    public int getNumberOfBacklogOrders(int[][] orders) {
        long res = 0;
        PriorityQueue<int[]> sells = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> buys = new PriorityQueue<>((o1,o2) -> (o2[0]-o1[0]));
        for (int[] order : orders) {
            //0 represents buy
            if (order[2] == 0) {
                //如果sells队列为空，或没有可以匹配的元素，则buy订单进入积压状态
                if (sells.isEmpty()) buys.add(new int[] {order[0],order[1]});
                else {
                    if (sells.peek()[0] > order[0]) buys.add(new int[] {order[0],order[1]});
                    //如果有可以匹配的元素，则依次取出比较
                    else {
                        while (!sells.isEmpty() && sells.peek()[0] <= order[0]) {
                            int[] sell = sells.poll();
                            //注意边界处理，如果sell量大于order量，则完成当前订单，剩余部分重新加入队列
                            if (sell[1] > order[1]) {
                                sell[1] -= order[1];
                                order[1] = 0;
                                sells.add(sell);
                                break;
                            }
                            //如果order量大于等于sell量，则完成一个sell订单，已经取出的sell订单不再放回去
                            else order[1] -= sell[1];
                        }
                        //如果当前order订单最终仍有剩余，则进入积压状态
                        if (order[1] > 0) buys.add(new int[] {order[0],order[1]});
                    }
                }
            }
            //1 represents sell，同上
            if (order[2] == 1) {
                if (buys.isEmpty()) sells.add(new int[] {order[0], order[1]});
                else {
                    if (buys.peek()[0] < order[0]) sells.add(new int[] {order[0], order[1]});
                    else {
                        while (!buys.isEmpty() && buys.peek()[0] >= order[0]) {
                            int[] buy = buys.poll();
                            if (buy[1] > order[1]) {
                                buy[1] -= order[1];
                                order[1] = 0;
                                buys.add(buy);
                                break;
                            }
                            else order[1] -= buy[1];
                        }
                        if (order[1] > 0) sells.add(new int[] {order[0],order[1]});
                    }
                }
            }
        }
        while (!sells.isEmpty()) res += sells.poll()[1];
        while (!buys.isEmpty()) res += buys.poll()[1];
        return (int) (res % M);
    }
}
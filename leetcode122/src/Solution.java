import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    //笑死，单调区间是困难题的思路
    public int maxProfit(int[] prices) {
        //记录每个单调区间的极值差和当前的极值点
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        //数组去重，单调区间的相邻点不能相等
        List<Integer> nonRepeat = new ArrayList<>();
        nonRepeat.add(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i-1]) continue;
            nonRepeat.add(prices[i]);
        }
        int n = nonRepeat.size();
        for (int i = 1; i < n; i++) {
            //满足极值点条件需要该点与左右相邻点之差同号
            if (i == n - 1 || (nonRepeat.get(i) - nonRepeat.get(i-1)) * (nonRepeat.get(i) - nonRepeat.get(i+1)) > 0) {
                //如果deque为空，说明在i之前始终是单调区间
                if (deque.isEmpty()) deque.add(new int[] {nonRepeat.get(i) - nonRepeat.get(0),i});
                //添加两个极值点之差
                else deque.add(new int[] {nonRepeat.get(i) - nonRepeat.get(deque.peekLast()[1]),i});
            }
        }
        //将所有递增区间相加
        int res = 0;
        while (!deque.isEmpty()) {
            res += Math.max(0,deque.poll()[0]);
        }
        return res;
    }
}
class Solution2 {
    //贪心算法，直接相加递增区间
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0,prices[i] - prices[i - 1]);
        }
        return res;
    }
}
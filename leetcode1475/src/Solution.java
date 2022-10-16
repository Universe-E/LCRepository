import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i =  n - 1; i >= 0; i--) {
            //注意单调栈出栈条件不能取等号，否则相等值不能相减为0
            while (!stack.isEmpty() && prices[i] < stack.peek()) stack.pop();
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return res;
    }
}

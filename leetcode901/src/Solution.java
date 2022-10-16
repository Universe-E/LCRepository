import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {

    Deque<int[]> stack;
    int p;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        p = 0;
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[1] <= price) stack.pop();
        //上一个峰值所在的索引
        int lastPeak = stack.isEmpty() ? 0 : stack.peek()[0];
        p++;
        stack.push(new int[] {p,price});
        //结果为两峰值之差
        return p - lastPeak;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
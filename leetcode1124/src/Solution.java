import java.util.ArrayDeque;

class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] t = new int[n], pre = new int[n+1];
        //corresponding if hours[i] > 1 or not
        for (int i = 0; i < n; i++) {
            if (hours[i] > 8) t[i] = 1;
            else t[i] = -1;
        }
        //preSum of num
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + t[i];
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //add elements monotonically decrease
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || pre[i] < pre[stack.peek()]) stack.push(i);
        }
        int res = 0;
        //pop elements and record res
        for (int i = n; i >= 0; i--) {
            while (!stack.isEmpty() && pre[i]-pre[stack.peek()]>0) res = Math.max(res,i - stack.pop());
        }
        return res;
    }
}
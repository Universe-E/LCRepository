import java.util.ArrayDeque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            //如果遇到较大的值，就将栈中较小的值取出，与当前值的索引差记为相差的天数
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int p = stack.pop()[0];
                res[p] = i - p;
            }
            //当栈中没有比当前值更小的元素时，将当前值压入栈
            stack.push(new int[] {i,temperatures[i]});
        }
        return res;
    }
}
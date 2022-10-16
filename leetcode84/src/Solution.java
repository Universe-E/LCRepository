import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    //单调栈的思路
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] temp = new int[heights.length + 1];
        System.arraycopy(heights,0,temp,0,heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        //当前i是栈顶右侧第一个比temp[i]小的点，因此width可以直接计算
        //对于栈中元素，下一个元素即为其左侧第一个小于自身的序号
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int height = temp[stack.pop()];
                //如果栈已经为空，则不再进行减操作
                int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                res = Math.max(res,height * width);
            }
            stack.push(i);
        }
        return res;
    }
}

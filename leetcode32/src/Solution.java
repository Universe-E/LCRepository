import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.equals("")) return 0;
        char[] temp = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);//保证栈底元素始终为最后一个未匹配的右括号
        int res = 0;
        for (int i = 0; i < temp.length; i++) {
            //如果是左边界，直接放置即可
            if (temp[i] == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    res = Math.max(res, i- stack.peek());
                }
            }
        }
        return res;
    }

}

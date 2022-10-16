import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        int res = 0,cur = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') stack.push(cs[i]);
            else {
                stack.pop();
                //用栈当前的大小控制计算
                cur = Math.max(cur,(int) Math.pow(2,stack.size()));
            }
            if (cs[i] == '(' || i == n - 1) {
                res += cur;
                cur = 0;
            }
        }
        return res;
    }
}
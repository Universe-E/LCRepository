import java.util.ArrayDeque;

class Solution {
    public String reverseParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        //stack记录每个括号的位置
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') stack.push(i);
            //翻转[上一个左括号+1,当前i-1]区间
            if (cs[i] == ')') reverse(cs,stack.pop()+1,i-1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c != '(' && c != ')') sb.append(c);
        }
        return sb.toString();
    }

    private void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char temp = cs[l];
            cs[l] = cs[r];
            cs[r] = temp;
            l++;
            r--;
        }
    }
}
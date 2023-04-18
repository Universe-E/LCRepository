import java.util.ArrayDeque;

class Solution {
    public int calculate(String s) {
        int res = 0;
        s += '+';
        int n = s.length();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            //每次遇到的符号到下一次再处理
            else {
                if (op == '+') stack.push(num);
                else if (op == '-') stack.push(-num);
                else if (op == '*') {
                    num = stack.pop() * num;
                    stack.push(num);
                }
                else if (op == '/') {
                    num = stack.pop() / num;
                    stack.push(num);
                }
                op = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
    
}
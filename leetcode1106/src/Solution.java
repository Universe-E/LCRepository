import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean parseBoolExpr(String expression) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ')') {
                List<Character> temp = new ArrayList<>();
                //得到每一层的布尔结果，存在temp中
                while (!stack.isEmpty()) {
                    char ch = stack.pop();
                    if (ch == 'f' || ch == 't') temp.add(ch);
                    if (ch == '(') break;
                }
                char cal = stack.pop();
                //将计算结果再次推入单调栈中，完成一次evaluation
                stack.push(calculate(cal,temp) ? 't' : 'f');
            }
            if (c != ')') stack.push(c);
        }
        //最终，单调栈中只会有一个布尔结果
        return stack.peek() == 't';
    }

    private boolean get(char c) {
        return c == 't';
    }

    //计算每一层括号内的布尔结果
    private boolean calculate(char cal,List<Character> temp) {
        boolean bool = false;
        for (int i = 0; i < temp.size(); i++) {
            if (i == 0) bool = get(temp.get(i));
            if (cal == '!') return !bool;
            if (cal == '|') bool |= get(temp.get(i));
            if (cal == '&') bool &= get(temp.get(i));
        }
        return bool;
    }
}
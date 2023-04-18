import java.util.ArrayDeque;
import java.util.HashSet;

class Solution {
    static HashSet<String> set = new HashSet<>();
    static {
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
    }
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        int res = 0;
        for (String token : tokens) {
            if (!set.contains(token)) stack.push(token);
            else {
                int r = Integer.parseInt(stack.pop());
                int l = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(l + r));
                        break;
                    case "-":
                        stack.push(String.valueOf(l - r));
                        break;
                    case "*":
                        stack.push(String.valueOf(l * r));
                        break;
                    case "/":
                        stack.push(String.valueOf(l / r));
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
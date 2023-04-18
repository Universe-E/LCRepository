import java.util.ArrayDeque;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(c);
                }
            }
            else if (c == '(') {
                stack.push(c);
                sb.append(c);
            }
            else sb.append(c);
        }
        char[] cs = sb.toString().toCharArray();
        sb = new StringBuilder();
        stack.clear();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '(') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.insert(0,cs[i]);
                }
            }
            else if (cs[i] == ')') {
                stack.push(cs[i]);
                sb.insert(0,cs[i]);
            }
            else sb.insert(0,cs[i]);
        }
        return sb.toString();
    }
}
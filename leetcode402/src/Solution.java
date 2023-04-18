import java.util.ArrayDeque;

class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        int n = num.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(num.charAt(0));
        for (int i = 1; i < n; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            if (!(stack.isEmpty() && c == '0')) stack.push(c);
        }
        //此时的栈一定是顺序
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0,stack.pop());
        return sb.length()==0 ? "0" : sb.toString();
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("/");
        for (int l = 0,r = 0; r < path.length(); r++) {
            if ((l != r && path.charAt(r) == '/') || r == path.length() - 1) {
                String s = "";
                if (r == path.length() - 1 && path.charAt(r) != '/') s = path.substring(l + 1,r + 1);
                else if (l != r) s = path.substring(l + 1,r);
                if (s.length() != 0) {
                    if (s.equals("..")) {
                        if (stack.size() != 1) stack.pop();
                        else {
                            l = r;
                            continue;
                        }
                    }
                    else if (!s.equals(".")) stack.push(s + "/");
                }
                l = r;
            }
        }
        StringBuilder sb = new StringBuilder();
        int n = stack.size();
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        if (n != 1) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
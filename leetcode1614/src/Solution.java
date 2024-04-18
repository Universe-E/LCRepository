import java.util.ArrayDeque;

class Solution {
    public int maxDepth(String s) {
        int res = 0;
        var q = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') q.addLast(c);
            else if (c == ')') {
                res = Math.max(res,q.size());
                q.pollLast();
            }
        }
        return res;
    }
}
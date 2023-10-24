import java.util.ArrayDeque;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return f(s).equals(f(t));
    }

    private String f(String s) {
        var q = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (q.isEmpty()) continue;
                q.pollLast();
            }
            else q.addLast(c);
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) res.append(q.pollFirst());
        return res.toString();
    }
}
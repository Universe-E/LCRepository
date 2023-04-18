import java.util.ArrayDeque;

class Solution {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        ArrayDeque<Character> q = new ArrayDeque<>();
        int n = s.length(), i = n-1;
        while (i >= 0) {
            while (i >= 0 && !q.isEmpty() && s.charAt(i) != '*') {
                q.pollLast();
                i--;
            }
            if (i < 0) break;
            if (s.charAt(i) == '*') {
                q.addLast(s.charAt(i));
            }
            else {
                res.append(s.charAt(i));
            }
            i--;
        }
        return res.reverse().toString();
    }
}
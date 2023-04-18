import java.util.ArrayDeque;

class Solution {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length(),cur = 0;
        for (int i = n-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') cur++;
            else {
                if (cur == 0) res.append(c);
                else cur--;
            }
        }
        return res.reverse().toString();
    }
}
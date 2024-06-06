import java.util.ArrayDeque;

class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        var q = new ArrayDeque<Character>();
        long res = 0;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '0') q.addLast(s.charAt(i));
            else if (s.charAt(i) == '1') res += q.size();
        }
        return res;
    }
}
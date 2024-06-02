import java.util.HashSet;

class Solution {
    public int maximumLength(String s) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < 26; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append((char)('a' + i));
                set.add(sb.toString());
            }
        }
        int res = -1;
        for (String s1 : set) {
            if (s1.length() >= s.length()) continue;
            if (ok(s,s1)) res = Math.max(res,s1.length());
        }
        return res;
    }

    private boolean ok(String s, String s1) {
        int cnt = 0;
        for (int i = s1.length()-1; i < s.length(); i++) {
            if (s.startsWith(s1, i-s1.length()+1)) cnt++;
        }
        return cnt >= 3;
    }
}
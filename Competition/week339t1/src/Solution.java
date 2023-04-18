import java.util.HashSet;

class Solution {
    static HashSet<String> set = new HashSet<>();
    static {
        for (int i = 0; i <= 26; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i; j++) stringBuilder.append(0);
            for (int j = 0; j < i; j++) stringBuilder.append(1);
            set.add(stringBuilder.toString());
        }
    }
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        for (String ss : set) {
            if (s.contains(ss))
                ans = Math.max(ans,ss.length());
        }
        return ans;
    }
}
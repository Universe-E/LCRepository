import java.util.Arrays;

class Solution {
    public int beautySum(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        if (n == 1 || n == 2) return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            if (i >= 2) {
                int[] cur = Arrays.copyOf(cnt,26);
                for (int j = 0; j < i-1; j++) {
                    int max = 0, min = 505;
                    for (int k = 0; k < 26; k++) {
                        if (cur[k] == 0) continue;
                        max = Math.max(max,cur[k]);
                        min = Math.min(min,cur[k]);
                    }
                    res += max-min;
                    cur[s.charAt(j) - 'a']--;
                }
            }
        }
        return res;
    }
}
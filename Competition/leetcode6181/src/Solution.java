import java.util.Arrays;

class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(dp[i],res);
            }
        }
        return res;
    }
}
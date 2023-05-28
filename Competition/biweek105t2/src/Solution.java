import java.util.Arrays;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (String s1 : dictionary) {
                if (s.startsWith(s1, i)) {
                    dp[i+s1.length()] = Math.min(dp[i+s1.length()],dp[i]);
                }
            }
            dp[i+1] = Math.min(dp[i+1],dp[i]+1);
        }
        return dp[n];
    }
}
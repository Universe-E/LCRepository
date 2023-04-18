class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                //处理2的特殊情况
                dp[i] = Math.max(dp[i],(i-j)*Math.max(j,dp[j]));
            }
        }
        return dp[n];
    }
}
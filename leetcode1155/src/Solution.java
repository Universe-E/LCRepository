class Solution {
    private static final int M = (int) 1e9+7;
    private static final int inf = 0x3f3f3f3f;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -inf;
            }
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l <= target; l++) {
                    if (l-j >= 0 && l-j <= target && dp[i-1][l-j] != -inf) {
                        dp[i][l] = (Math.max(dp[i][l],0)+dp[i-1][l-j])%M;
                    }
                }
            }
        }
        return dp[n][target] == -inf ? 0 : dp[n][target];
    }
}
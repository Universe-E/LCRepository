class Solution {
    public static final int M = (int)1e9+7;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int cnt = types[i-1][0], mark = types[i-1][1];
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= cnt && k*mark <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k*mark])%M;
                }
            }
        }
        return dp[n][target];
    }
}
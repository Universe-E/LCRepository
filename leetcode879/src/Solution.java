class Solution {
    public static final int M = (int)1e9 + 7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit += profit[i];
        }

        int[][] dp = new int[n+1][maxProfit+1];//dp[i][j]表示使用i个人获得j利润的方案数
        dp[0][0] = 1;
        //dp[i][j] = ∑k (dp[i][j] + dp[i-g[k]][j-p[k]])
        for (int k = 0; k < len; k++) {
            int g = group[k], p = profit[k];
            for (int i = n; i >= g; i--) {
                for (int j = maxProfit; j >= p; j--) {
                    dp[i][j] = (dp[i][j] + dp[i-g][j-p]) % M;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = minProfit; j <= maxProfit; j++) {
                res = (res + dp[i][j]) % M;
            }
        }
        return res;
    }
}
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //k已经右移了1位，再加上总共k个状态，因此是k+2
        int[][][] dp = new int[n+1][k+2][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k+1; j++) {
                dp[i][j][0] = dp[i][j][1] = -0x3f3f3f3f;
            }
        }
        for (int j = 1; j <= k+1; j++) {
            dp[0][j][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k+1; j++) {
                //一买一卖才算一笔交易，因此只有卖出的时候才从j-1转移过来
                dp[i+1][j][0] = Math.max(dp[i][j][0],dp[i][j-1][1] + prices[i]);
                //仅买入不算一笔交易
                dp[i+1][j][1] = Math.max(dp[i][j][1],dp[i][j][0] - prices[i]);
            }
        }
        return dp[n][k+1][0];
    }
}
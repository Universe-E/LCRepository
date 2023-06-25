class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[2][2];//dp[i][0]表示当天没有持有股票，dp[i][1]表示当天持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i%2][0] = Math.max(dp[(i-1)%2][0],dp[(i-1)%2][1]+prices[i]-fee);//仍然没有持有股票，或卖出股票
            dp[i%2][1] = Math.max(dp[(i-1)%2][1],dp[(i-1)%2][0]-prices[i]);//继续持有股票，或买入股票
        }
        return dp[(n-1)%2][0];
    }
}
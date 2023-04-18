class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[i]有4种状态：1、此时未持有股票，什么都不做；2、此时已持有股票，什么都不做；3、当日卖出；4、处于冷冻期
        int[][] dp = new int[n][4];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //未持有股票且什么都不做，前一天肯定也未持有股票（可能处于冷冻期，也可能不处于）
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][3]);
            //已持有股票且什么都不做，如果今天要买，就从dp[i-1][0]或者dp[i-1][3]里面扣费，否则保持不变
            dp[i][1] = Math.max(Math.max(dp[i-1][0],dp[i-1][3])-prices[i],dp[i-1][1]);
            //当日卖出
            dp[i][2] = dp[i-1][1] + prices[i];
            //处于冷冻期
            dp[i][3] = dp[i-1][2];
        }
        //最后一天肯定不可能再买股票，因此从0,2,3里面取最大值
        return Math.max(dp[n-1][0],Math.max(dp[n-1][2],dp[n-1][3]));
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[i]有3种状态：1、此时未持有股票，什么都不做（可以是冷冻期，也可以不是）；2、此时已持有股票，什么都不做；3、当日卖出
        int[][] dp = new int[n][3];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //未持有股票且什么都不做，前一天肯定也未持有股票（可能处于冷冻期，也可能不处于）
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
            //已持有股票且什么都不做，如果今天要买，就从dp[i-1][0]里面扣费，否则保持不变
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            //当日卖出
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        //最后一天肯定不可能再买股票，因此从0,2里面取最大值
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
}
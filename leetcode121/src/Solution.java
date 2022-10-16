class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        //初始时默认0买入
        int i = 0;
        int res = 0;
        //从索引1开始，如果当前价格比之前最低值低，则更新买入点；如果当前价格差比之前高，则让收益更新
        for (int k = 1; k < prices.length; k++) {
            if (prices[k] < prices[i]) i = k;
            if (k > i && prices[k] - prices[i] > res) res = prices[k] - prices[i];
        }
        return res;
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i-1],prices[i]);
            res = Math.max(res,prices[i]-dp[i]);
        }
        return res;
    }
}
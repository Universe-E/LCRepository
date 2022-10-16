class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp1从前往后遍历，代表第i天卖掉股票的最大收益，同时更新股票最低点
        //dp2从后往前遍历，代表第i天买入股票的最大收益，同时更新股票最高点
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int min = prices[0], max = prices[n - 1];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1],prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1],max - prices[i]);
            max = Math.max(max,prices[i]);
        }
        //dp1和dp2状态不会重合，因为第i天dp1已处于卖出状态
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,dp1[i] + dp2[i]);
        }
        return res;
    }
}
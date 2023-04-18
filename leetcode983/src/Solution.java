class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length,maxD = days[n-1],minD = days[0];
        int[] dp = new int[maxD+1];
        for (int d = minD,i = 0;d <= maxD;d++) {
            if (d == days[i]) {
                int cost1 = dp[d-1]+costs[0];
                int cost2 = costs[1] + (d>=7 ? dp[d-7] : 0);
                int cost3 = costs[2] + (d>=30 ? dp[d-30] : 0);
                dp[d] = Math.min(cost1,Math.min(cost2,cost3));
                i++;
            }
            else dp[d] = dp[d-1];
        }
        return dp[maxD];
    }
}

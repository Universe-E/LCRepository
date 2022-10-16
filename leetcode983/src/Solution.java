class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        for (int i = 0; i < days.length; i++) {
            if (i == 0) {
                dp[i] = Math.min(costs[0],Math.min(costs[1],costs[2]));
                continue;
            }
            //第一种情况，该日买单日票
            int cost1 = dp[i - 1] + costs[0];
            int lastWeek = 0,lastMonth = 0;
            //第二种情况，从该日找到最近7天内最早出行的某天，这一天买7日票并与此前出行的费用合计
            //但要注意的是，如果涵盖第一次出行，则要去掉第一次的费用，即此时dp[0] = cost2
            for (int j = i; j >= 0 && days[j] >= days[i] - 6; j--) lastWeek = j;
            int cost2 = lastWeek == 0 ? costs[1] : dp[lastWeek - 1] + costs[1];
            //第三种情况，从该日找到最近30天内最早出行的某天，这一天买30日票并与此前的费用合计
            for (int j = i; j >= 0 && days[j] >= days[i] - 29; j--) lastMonth = j;
            int cost3 = lastMonth == 0 ? costs[2] : dp[lastMonth - 1] + costs[2];
            //最后，对于该日，汇总3种情况
            dp[i] = Math.min(cost1,Math.min(cost2,cost3));
        }
        return dp[dp.length - 1];
    }
}

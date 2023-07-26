class Solution {
    public double soupServings(int n) {
        //由于n=1e9，即使进行了除25的缩放操作，过多的状态数仍会导致 TLE。
        //此时需要利用「返回值在正确答案10^−5的范围内将被认为是正确的」来做优化（一下子不太好想到）：
        //由于四类操作均是等概率，单个回合期望消耗汤 A 的量为2.5，消耗汤 B 的量为1.5。
        //因此当n足够大，操作回合足够多，汤 A 将有较大的概率结束分配，即当足够大，概率值会趋向于1。
        //我们考虑多大的n能够配合精度误差10^−5来减少计算量：
        //一个可行的操作是利用上述的 DP 思路 + 二分的方式找到符合精度要求的验算值（不超过200）。
        n = Math.min(200,(int) Math.ceil(n/25d));
        double[][] dp = new double[n+4][n+4];
        dp[0][0] = 0.5;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double a = dp[Math.max(0,i-4)][j],b = dp[Math.max(0,i-3)][j-1],
                        c = dp[Math.max(0,i-2)][Math.max(0,j-2)],d = dp[i-1][Math.max(0,j-3)];
                dp[i][j] = 1/4d * (a+b+c+d);
            }
        }
        return dp[n][n];
    }
}
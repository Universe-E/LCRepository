import java.util.Arrays;

class Solution {
    private static final int inf = 0x3f3f3f3f;
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        var dp = new int[n+1][n+1];//dp[i][j]表示付费工酱刷i面墙时，总共粉刷j面墙的最小花费
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],inf);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]);//先转移状态
                //选i，此时付费粉刷匠刷1面墙，免费粉刷匠刷time[i]面墙
                int all = Math.min(n,j+time[i]+1);
                //选或不选取最小值，左边不选，右边选
                dp[i+1][all] = Math.min(dp[i+1][all],dp[i][j]+cost[i]);
            }
        }
        return dp[n][n];
    }
}
public class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n-1)%(k-1) != 0) return -1;
        int[] pre = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + stones[i-1];
        }
        int[][] dp = new int[n][n];
        //i < m+1,dp[i]要从dp[m+1]枚举出来，所以i应该倒序
        //同理j > m,dp[j]要从dp[m]没举出来，所以j应该顺序
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = 0x3f3f3f3f;//初始化
                for (int m = i; m < j; m += k-1) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][m] + dp[m+1][j]);
                }
                //这样可以压缩一维
                if ((j-i)%(k-1) == 0) dp[i][j] += pre[j+1]-pre[i];
            }
        }
        return dp[0][n-1];
    }
}

class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] p = new int[m+1][n+1];
        for (int[] price : prices) {
            p[price[0]][price[1]] = price[2];
        }
        long[][] dp = new long[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = p[i][j];
                //对于点[i,j]，枚举水平切割、竖直切割、不切割
                //水平切割，枚举高度
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-k][j]+dp[k][j]);
                }
                //竖直切割，枚举宽度
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-k]+dp[i][k]);
                }
            }
        }
        return dp[m][n];
    }
}
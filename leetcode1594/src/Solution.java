class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int M = (int)(1e9+7);
        //dp array store the biggest abs value (both positive and negative)
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i-1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i][0][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i-1][0] * grid[0][i];
            dp[0][i][1] = dp[0][i][0];
        }
        //dp[i][j][0] stores positive,and dp[i][j][1] stores negative
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long up1 = dp[i-1][j][0] * grid[i][j];
                long up2 = dp[i-1][j][1] * grid[i][j];
                long left1 = dp[i][j-1][0] * grid[i][j];
                long left2 = dp[i][j-1][1] * grid[i][j];
                dp[i][j][0] = Math.max(up1,Math.max(up2,Math.max(left1,left2)));
                dp[i][j][1] = Math.min(up1,Math.min(up2,Math.min(left1,left2)));
            }
        }
        System.out.println((-9)%10);
        long res = dp[m-1][n-1][0] >= 0 ? dp[m-1][n-1][0] : -1;
        return (int) (res % M);
    }
}
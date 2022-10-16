class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //如果遇到障碍，则障碍上或左方向的路全都走不通
        boolean isBlocked = false;
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                dp[i][n - 1] = 0;
                isBlocked = true;
            }
            else dp[i][n - 1] = isBlocked ? 0 : 1;
        }
        isBlocked = false;
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                dp[m - 1][i] = 0;
                isBlocked = true;
            }
            else dp[m - 1][i] = isBlocked ? 0 : 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}

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

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            //transfer status line by line
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j > 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }
}
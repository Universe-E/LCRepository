import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[][] dp = new int[2][m];
        System.arraycopy(grid[0], 0, dp[0], 0, m);
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i%2],0x3f3f3f3f);
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (k != j) dp[i%2][j] = Math.min(dp[i%2][j],grid[i][j]+dp[(i-1)%2][k]);
                }
            }
        }
        int res = 0x3f3f3f3f;
        for (int j = 0; j < m; j++) {
            res = Math.min(res,dp[(n-1)%2][j]);
        }
        return res;
    }
}
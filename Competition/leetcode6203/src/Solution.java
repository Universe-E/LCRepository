class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        //dp[i][j][l]表示从[0,0]到[i,j]的路径和与k取模等于l的条数
        dp[0][0][grid[0][0] % k] = 1;
        int M = (int) (1e9+7);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                for (int l = 0; l < k; l++) {
                    dp[i][j][(l + grid[i][j]) % k] =
                            ((i == 0 ? 0 : dp[i-1][j][l]) + (j == 0 ? 0 : dp[i][j-1][l])) % M;
                }
            }
        }
        return dp[m-1][n-1][0];
    }
}
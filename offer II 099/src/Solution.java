class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        //initialize dp
        dp[m-1][n-1] = grid[m-1][n-1];
        //the bottom bound
        for (int j = n-2; j >= 0; j--) {
            dp[m-1][j] = dp[m-1][j+1] + grid[m-1][j];
        }
        //the right bound
        for (int i = m-2; i >=0; i--) {
            dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1];
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
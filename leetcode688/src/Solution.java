class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        //dp[step][i][j]表示从[i,j]出发，走了step步时留在棋盘上的概率
        final int[][] d = new int[][] {{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2}};
        for (int steps = 0; steps <= k; steps++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (steps == 0) dp[steps][i][j] = 1;
                    else {
                        for (int[] ints : d) {
                            int x = i + ints[0],y = j + ints[1];
                            if (x < 0 || x >= n || y < 0 || y >= n) continue;
                            dp[steps][i][j] += dp[steps - 1][x][y] / 8;
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
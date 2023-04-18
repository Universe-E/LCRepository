class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        //pour all the champagne into top glass, then flow down
        dp[0][0] = poured;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (dp[i][j] >= 1) {
                    //flow downstairs
                    double remain = dp[i][j] - 1;
                    dp[i][j] = 1;
                    dp[i+1][j] += remain / 2;
                    dp[i+1][j+1] += remain / 2;
                }
            }
        }
        return dp[query_row][query_glass];
    }
}
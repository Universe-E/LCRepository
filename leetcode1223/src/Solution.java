class Solution {
    public static final int M = (int)1e9+7;
    public int dieSimulator(int n, int[] rollMax) {
        //dp[i][j]表示第i次投掷以j结尾的个数
        long[][] dp = new long[n+1][7];
        //初始化，第一次投掷每个j都是1
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                //先将之前以1-6为结尾的结果全部添加一遍j
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] = (dp[i][j]+dp[i-1][k])%M;
                }
                //如果是第一次达到rollMax[j-1]，直接减一即可，因为i-rollMax[j-1] == 1
                if (i-rollMax[j-1] == 1) dp[i][j] = (dp[i][j]-1+M)%M;
                //如果不是第一次达到rollMax[j-1]，则在第i-rollMax[j-1]-1次选择中，一定不会选择当前j
                    // 此时减去dp[i-rollMax[j-1]-1]的其他所有可能性
                else if (i-rollMax[j-1] > 1) {
                    for (int k = 1; k <= 6; k++) {
                        if (k == j) continue;
                        dp[i][j] = (dp[i][j]-dp[i-rollMax[j-1]-1][k]+M)%M;
                    }
                }
            }
        }
        long res = 0;
        for (int j = 1; j <= 6; j++) {
            res += dp[n][j];
        }
        return (int) (res%M);
    }
}
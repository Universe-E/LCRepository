class Solution {
    public static final int INF = 0x3f3f3f3f;
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n-1)%(k-1) != 0) return -1;
        //将区间[i,j]合并到k堆的情况，记为dp[i][j][k]，答案是dp[1][n][1]
        int[][][] dp = new int[n+1][n+1][k+1];
        //记录一下前缀和
        int[] pre = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + stones[i-1];
        }
        //初始化，全部记为最大值
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                //m从2开始，因为1堆的情况不需要合并，成本已经是0
                for (int m = 2; m <= k; m++) {
                    dp[i][j][m] = INF;
                }
            }
        }
        //枚举区间长度，默认为2
        for (int len = 2; len <= n; len++) {
            //枚举区间起点
            for (int l = 1; l <= n - len + 1; l++) {
                int r = l + len - 1;//当前区间长度右边界
                //枚举堆数
                for (int m = 2; m <= k; m++) {
                    //左部分合并为1堆，右部分合并为k-1堆
                    //枚举分界点，步长一定是k-1，因为其他的步长没有意义，无法将剩余堆合并成1堆
                    for (int i = l; i < r; i += k - 1) {
                        dp[l][r][m] = Math.min(dp[l][r][m], dp[l][i][1] + dp[i + 1][r][m - 1]);
                    }
                }
                dp[l][r][1] = dp[l][r][k] + pre[r] - pre[l - 1];
            }
        }
        return dp[1][n][1];
    }
}
class Solution {
    public static final int M = (int) 1e9+7;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int[][] dp = new int[n+1][target+1];//dp[i][j]表示前i题获得j分的方案数(i从1开始)
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int cnt = types[i][0],score = types[i][1];
            for (int j = 0; j <= target; j++) {
                //k等于0时，dp[i][j]直接从dp[i-1][j]继承而来
                for (int k = 0; k <= cnt && j - k * score >= 0; k++) {
                    dp[i+1][j] = (dp[i+1][j]+dp[i][j-k*score])%M;
                }
            }
        }
        return dp[n][target];
    }
}

class Solution {
    public static final int M = (int) 1e9+7;
    public int waysToReachTarget(int target, int[][] types) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int[] type : types) {
            int cnt = type[0],score = type[1];
            //注意滚动数组优化后要倒序枚举，由于0已经被初始化，因此枚举到1
            for (int j = target; j > 0; j--) {
                //k不能从0枚举，k=0 是 f[j]，在空间压缩后，它直接继承了 f[i-1][j] 的结果，不能重复计算
                for (int k = 1; k <= cnt && j-k*score >= 0; k++) {
                    dp[j] = (dp[j]+dp[j-k*score])%M;
                }
            }
        }
        return dp[target];
    }
}
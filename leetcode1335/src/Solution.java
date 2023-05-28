import java.util.Arrays;

class Solution {
    public static final int inf = 0x3f3f3f3f;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        //dp[i][j]表示当前第j组的分隔点在i处，此时对应的最小值
        //答案为min(dp[d])
        int[][] dp = new int[n][d+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],inf);
        }
        //初始化第1组的情况
        for (int i = 0,cur = 0; i < n; i++) {
            cur = Math.max(cur,jobDifficulty[i]);
            dp[i][1] = cur;
        }
        //对于第i组，枚举分隔点j
        for (int j = 2; j <= d; j++) {//枚举从第1组到第d组的情况
            for (int i = j-1; i < n-d+j; i++) {//枚举第j组的分隔点，对于第j组，分隔点的取值范围是[j-1,n-d+j)
                for (int i0 = i-1,cur = jobDifficulty[i]; i0 >= j-2; i0--) {//枚举第i-1组的情况
                    cur = Math.max(cur,jobDifficulty[i0+1]);//cur是[i0+1,i]范围内的最大值
                    dp[i][j] = Math.min(dp[i][j],dp[i0][j-1]+cur);
                }
            }
        }
        return dp[n-1][d];
    }
}

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[d + 1][n];
        for (int i = 0; i <= d; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        for (int i = 0,ma = 0; i < n; ++i) {
            ma = Math.max(ma, jobDifficulty[i]);
            dp[0][i] = ma;
        }
        for (int i = 1; i < d; ++i) {
            for (int j = i; j < n; ++j) {
                for (int k = j,ma = 0; k >= i; --k) {
                    ma = Math.max(ma, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], ma + dp[i - 1][k - 1]);
                }
            }
        }
        return dp[d - 1][n - 1];
    }
}
import java.util.Arrays;

class Solution {
    private static final int L = 1000000;
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        dp[0][0] = 1;
        dp[0][2] = 1;
        //到达每一点有两种情况：1、从dp[i-1][j]直走过来；2、从dp[i][j2]跳过来
        for (int i = 1; i < n; i++) {
            //将当前有障碍的道路标记为-1
            if (obstacles[i] != 0) dp[i][obstacles[i]-1] = -1;
            //默认情况下，每个点都是从前一个点直走过来，不需要跳，如果前一点有障碍，则该点无法直走到达，置为1000000
            for (int j = 0; j < 3; j++) {
                if (dp[i][j] != -1) {
                    if (dp[i-1][j] != -1) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = L;
                }
            }
            //接下来考虑从相邻道路跳跃的情况，注意dp[i-1][j] = -1的点只能由相邻道路跳过来
            for (int j = 0; j < 3; j++) {
                if (dp[i][j] != -1) dp[i][j] = Math.min(dp[i-1][j] == -1 ? L : dp[i][j],
                            Math.min(1 + (dp[i][(j+1)%3] == -1 ? L : dp[i][(j+1)%3]),
                                    1 + (dp[i][(j+2)%3] == -1 ? L : dp[i][(j+2)%3])));
            }
        }
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}

class Solution2 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[3];
        dp[0] = dp[2] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacles[i] != 0) dp[obstacles[i]-1] = 0x3f3f3f3f;
            //分别更新最小的次数
            if (obstacles[i] != 1) dp[0] = Math.min(dp[0],Math.min(dp[1],dp[2]) + 1);
            if (obstacles[i] != 2) dp[1] = Math.min(dp[1],Math.min(dp[0],dp[2]) + 1);
            if (obstacles[i] != 3) dp[2] = Math.min(dp[2],Math.min(dp[0],dp[1]) + 1);
        }
        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }
}
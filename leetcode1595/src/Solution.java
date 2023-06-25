import java.util.Arrays;
import java.util.List;

class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int n1 = cost.size(),n2 = cost.get(0).size();
        int[][] grid = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            List<Integer> cur = cost.get(i);
            for (int j = 0; j < n2; j++) {
                grid[i][j] = cur.get(j);
            }
        }
        int[][] dp = new int[n1+1][1<<n2];//dp[i][j]表示左边前i个点连接右边集合j的最小开销
        for (int i = 0; i <= n1; i++) {
            Arrays.fill(dp[i],0x3f3f3f3f);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 0; j < (1 << n2); j++) {
                //考虑i与k的连接
                for (int k = 0; k < n2; k++) {
                    if ((j&(1<<k)) != 0) {
                        //i和k之前都没连接过别的
                        //i没连接过别的，k连接了
                        //i连接了，k没连接过别的
                        dp[i][j] = Math.min(dp[i][j],Math.min(dp[i-1][j ^ (1<<k)],Math.min(dp[i-1][j],dp[i][j ^ (1<<k)]))+grid[i-1][k]);
                    }
                }
            }
        }
        //左边和右边的集合都连接了
        return dp[n1][(1<<n2)-1];
    }
}
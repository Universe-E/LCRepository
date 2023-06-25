import java.util.Arrays;

class Solution {
    int n,finish;
    int[][] d,memo;
    public static final int M = (int) 1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        n = locations.length;
        this.finish = finish;
        d = new int[n][n];
        memo = new int[n][fuel+1];//memo[i][j]表示从i开始，剩余油量为j时到达finish的方法数
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],-1);
            for (int j = 0; j < n; j++) {
                //初始化距离，同时初始化dp
                d[i][j] = d[j][i] = Math.abs(locations[j]-locations[i]);
            }
        }
        return dfs(start,fuel);
    }

    private int dfs(int start,int fuel) {
        if (d[start][finish] > fuel) return 0;
        if (memo[start][fuel] != -1) return memo[start][fuel];
        memo[start][fuel] = 0;
        for (int i = 0; i < n; i++) {
            if (i == start) continue;
            memo[start][fuel] = (memo[start][fuel] + dfs(i,fuel-d[start][i]))%M;
        }
        if (start == finish) memo[start][fuel] = (memo[start][fuel]+1)%M;
        return memo[start][fuel];
    }
}
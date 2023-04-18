import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static final int[] d = new int[] {1,0,-1,0,1};
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //入口不能被堵死
        if (grid[1][0] > 1 && grid[0][1] > 1) return -1;
        //dp[i][j]为当前点的最短时间
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e,0x3f3f3f3f));
        boolean[][] v = new boolean[m][n];
        dp[0][0] = 0;
        v[0][0] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        pq.add(new int[] {0,0,0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0]==m-1 && cur[1]==n-1) return cur[2];
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + d[i],y = cur[1] + d[i+1];
                if (x < 0 || x >= m || y < 0 || y >= n || v[x][y]) continue;
                //如果相差大于1，则先让当前点“兜圈”
                if (grid[x][y] > cur[2]+1) {
                    if ((grid[x][y]-cur[2])%2==0) dp[x][y] = Math.min(dp[x][y],grid[x][y]+1);
                    else dp[x][y] = Math.min(dp[x][y],grid[x][y]);
                }
                else dp[x][y] = Math.min(dp[x][y],cur[2]+1);
                v[x][y] = true;
                pq.add(new int[] {x,y,dp[x][y]});
            }
        }
        return dp[m-1][n-1];
    }
}
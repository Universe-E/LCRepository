import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private static final int inf = 0x3f3f3f3f;
    int n,m;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int minimumEffortPath(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[][] dp = new int[n][m];//dp[i][j]表示从(0,0)到(i,j)的体力消耗
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],inf);
        }
        pq.add(new int[]{0,0,0});
        dp[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            int i = a[0],j = a[1],c = a[2];
            //到达终点
            if (i == n-1 && j == m-1) return c;
            if (c > dp[i][j]) continue;
            for (int k = 0; k < 4; k++) {
                int i2 = i+d[k],j2 = j+d[k+1];
                if (inArea(i2,j2)) {
                    //计算到达(i2,j2)的体力消耗
                    int c2 = Math.max(c,Math.abs(heights[i2][j2]-heights[i][j]));
                    if (c2 < dp[i2][j2]) {
                        dp[i2][j2] = c2;
                        pq.add(new int[]{i2,j2,c2});
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}
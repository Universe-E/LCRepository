import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public static final int[] d = new int[]{1,0,-1,0,1};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        int[][] v = new int[m][n];//v[i][j]表示当前点剩余破壁次数，初始化为-1
        for (int i = 0; i < m; i++) {
            Arrays.fill(v[i],-1);
        }
        ArrayDeque<int[]> ad = new ArrayDeque<>();
        //{x,y,k,step}
        ad.addLast(new int[] {0,0,k});
        v[0][0] = k;
        int steps = 0;
        while (!ad.isEmpty()) {
            steps++;
            int sz = ad.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = ad.pollFirst();
                int cx = cur[0],cy = cur[1],ck = cur[2];
                for (int j = 0; j < 4; j++) {
                    int x = cx + d[j], y = cy + d[j+1];
                    if (x == m-1 && y == n-1) return steps;
                    //越界或没有破壁次数，直接跳过
                    if (x < 0 || x >= m || y < 0 || y >= n || (grid[x][y]==1 && ck == 0)) continue;
                    int k2 = ck - (grid[x][y]==1 ? 1 : 0);
                    //如果当前层被访问过，且剩余次数比k2更多，则跳过
                    if (v[x][y] != -1 && v[x][y] >= k2) continue;
                    v[x][y] = k2;
                    ad.addLast(new int[]{x,y,k2});
                }
            }
        }
        return -1;
    }
}
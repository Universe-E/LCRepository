import java.util.ArrayDeque;

class Solution {
    int res = 0;
    int[][] grid;
    boolean[][] v;
    int m,n;
    public static final int[] d = new int[] {-1,0,1,0,-1};
    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j] && grid[i][j] != 0) {
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.addLast(new int[] {i,j});
                    v[i][j] = true;
                    int cur = 0;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int x = p[0],y = p[1];
                        cur += grid[x][y];
                        for (int k = 0; k < 4; k++) {
                            int cx = x + d[k],cy = y + d[k+1];
                            if (cx < 0 || cx >= m || cy < 0 || cy >= n || v[cx][cy] || grid[cx][cy] == 0) continue;
                            q.addLast(new int[] {cx,cy});
                            v[cx][cy] = true;
                        }
                    }
                    res = Math.max(res,cur);
                }
            }
        }
        return res;
    }
}
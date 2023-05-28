import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public static final int[][] d = new int[][] {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        var v = new boolean[n][n];
        var res = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i],0x3f3f3f3f);
        }
        var q = new ArrayDeque<int[]>();
        q.addLast(new int[]{0,0});
        v[0][0] = true;
        res[0][0] = 1;
        while (!q.isEmpty()) {
            int[] c = q.pollFirst();
            int x = c[0],y = c[1],r = res[x][y];
            for (int i = 0; i < 8; i++) {
                int cx = x+d[i][0],cy = y+d[i][1];
                if (cx < 0 || cx >= n || cy < 0 || cy >= n || v[cx][cy] || grid[cx][cy] != 0) continue;
                q.addLast(new int[]{cx,cy});
                res[cx][cy] = Math.min(res[cx][cy],r+1);
                v[cx][cy] = true;
            }
        }
        return res[n-1][n-1] == 0x3f3f3f3f ? -1 : res[n-1][n-1];
    }
}
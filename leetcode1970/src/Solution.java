import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    int[][] g;
    int n,m;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        n = row;
        m = col;
        g = new int[n][m];
        int l = 0,r = cells.length-1;
        while (l < r) {
            int mid = (l+r+1)/2;//l可能不更新，mid取上界避免死锁
            if (ok(mid,cells)) l = mid;
            else r = mid-1;
        }
        return l+1;//处理的是cells数组，天数从第1天计
    }

    private boolean ok(int mid,int[][] cells) {
        for (int[] ints : g) {
            Arrays.fill(ints, 0);
        }
        for (int i = 0; i <= mid; i++) {
            g[cells[i][0]-1][cells[i][1]-1] = 1;//注意坐标迁移
        }
        var q = new ArrayDeque<int[]>();
        var v = new boolean[n][m];
        //将第0行所有符合条件的点都放进去
        for (int j = 0; j < m; j++) {
            if (g[0][j] == 0) {
                q.addLast(new int[]{0,j});
                v[0][j] = true;
            }
        }
        while (!q.isEmpty()) {
            var c = q.pollFirst();
            if (c[0] == n-1) return true;
            for (int k = 0; k < 4; k++) {
                int cx = c[0]+d[k],cy = c[1]+d[k+1];
                if (inArea(cx,cy) && g[cx][cy] == 0 && !v[cx][cy]) {
                    q.addLast(new int[]{cx,cy});
                    v[cx][cy] = true;
                }
            }
        }
        return false;
    }
}
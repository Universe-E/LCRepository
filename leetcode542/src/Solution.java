import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    int n,m;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        var v = new boolean[n][m];
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i],0x3f3f3f3f);
        }
        var q = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int i2 = i+d[k],j2 = j+d[k+1];
                    //add all border 1
                    if (inArea(i2,j2) && mat[i2][j2] == 0) {
                        q.addLast(new int[]{i,j});
                        res[i][j] = 1;
                        v[i][j] = true;
                        break;
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            var a = q.pollFirst();
            int x = a[0],y = a[1],t = res[x][y];
            for (int k = 0; k < 4; k++) {
                int x2 = x+d[k],y2 = y+d[k+1];
                if (!inArea(x2,y2) || v[x2][y2] || mat[x2][y2] == 0) continue;
                q.addLast(new int[]{x2,y2});
                res[x2][y2] = Math.min(res[x2][y2],t+1);
                v[x2][y2] = true;
            }
        }
        return res;
    }
}
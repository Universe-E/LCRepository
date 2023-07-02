class Solution {
    public static final int[][] d = new int[][] {{0,1},{1,1},{-1,1}};//向右、右下、右上
    int n,m;
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int maxMoves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        var v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            v[i][0] = true;
        }
        int cnt = 0;
        for (int j = 0; j < m; j++) {
            boolean has = false;
            for (int i = 0; i < n; i++) {
                if (v[i][j]) {
                    has = true;
                    for (int k = 0; k < 3; k++) {
                        int ci = i+d[k][0],cj = j+d[k][1];
                        if (inArea(ci,cj) && grid[ci][cj] > grid[i][j]) v[ci][cj] = true;
                    }
                }
            }
            if (has) cnt++;
            else break;
        }
        return cnt-1;
    }
}
class Solution {
    int n,m,cnt,res;
    boolean[][] v;
    int[][] grid;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        cnt = 0;
        res = 0;
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) cnt++;
            }
        }
        cnt++;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) dfs(i,j,0);
            }
        }
        return res;
    }

    private void dfs(int i, int j, int c) {
        if (!inArea(i,j) || v[i][j] || grid[i][j] == -1) return;
        if (grid[i][j] == 2) {
            if (c == cnt) res++;
            return;
        }
        for (int k = 0; k < 4; k++) {
            v[i][j] = true;
            dfs(i+d[k],j+d[k+1],c+1);
            v[i][j] = false;
        }

    }

}
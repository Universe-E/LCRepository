class Solution {
    int[][] grid;
    int n,m;
    int cnt = 0;
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cnt = 0;
                    this.grid = grid;
                    if (dfs(i,j)) res += cnt;
                }
            }
        }
        return res;
    }

    private boolean dfs(int i,int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        if (grid[i][j] == 1) {
            cnt++;
            grid[i][j] = -1;
            boolean up = dfs(i-1,j),down = dfs(i+1,j),left = dfs(i,j-1),right = dfs(i,j+1);
            return up&&down&&left&&right;
        }
        else return true;
    }
}
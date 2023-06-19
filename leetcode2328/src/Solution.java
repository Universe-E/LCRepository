class Solution {
    int[][] grid, memo;
    int n,m;
    int res = 0;
    private static final int M = (int) 1e9+7;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = (res + dfs(i,j,0))%M;
            }
        }
        return res;
    }

    private int dfs(int i, int j, int pre) {
        if (!inArea(i,j) || grid[i][j] <= pre) return 0;
        if (memo[i][j] > 0) return memo[i][j];//memo dfs
        memo[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            memo[i][j] = (memo[i][j] + dfs(i+d[k],j+d[k+1],grid[i][j])) % M;
        }
        return memo[i][j];
    }
}
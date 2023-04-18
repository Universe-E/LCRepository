class Solution {
    public static final int[] d = new int[] {1,0,-1,0,1};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    infect(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void infect(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            infect(grid,i+d[k],j+d[k+1]);
        }
    }
}
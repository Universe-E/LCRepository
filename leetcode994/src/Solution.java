class Solution {
    int[] d = new int[] {-1,0,1,0,-1};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) dfs(grid,i,j,2);
            }
        }
        int res = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) return -1;
                if (ints[j] != 0) res = Math.max(res, ints[j] - 2);
            }
        }
        return res;
    }

    //route表示从2开始记录的遍历深度，最终结果要减2
    //只有2种情况继续dfs：
    //1、grid[i][j] = 1;
    //2、grid[i][j] 已被搜索过（>=2），但深度要更深
    private void dfs(int[][] grid, int i, int j, int route) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        if (grid[i][j] == 1 || grid[i][j] >= route) {
            grid[i][j] = route;
            for (int k = 0; k < 4; k++) {
                int cx = i + d[k], cy = j + d[k+1];
                dfs(grid,cx,cy,route+1);
            }
        }
    }
}
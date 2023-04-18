class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] res = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                res[j] = Math.max(res[j],String.valueOf(grid[i][j]).length());
            }
        }
        return res;
    }
}
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxRow = new int[n], maxCol = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRow[i] = Math.max(maxRow[i],grid[i][j]);
                maxCol[j] = Math.max(maxCol[j],grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.max(0,Math.min(maxRow[i],maxCol[j])-grid[i][j]);
            }
        }
        return res;
    }
}
import java.util.Arrays;

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i],1);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                while (i-cnt >= 0 && i + cnt < n && j-cnt >= 0 && j+cnt < n
                        && grid[i-cnt][j]==1 && grid[i+cnt][j]==1 && grid[i][j-cnt]==1 && grid[i][j+cnt]==1) cnt++;
                res = Math.max(res,cnt);
            }
        }
        return res;
    }
}
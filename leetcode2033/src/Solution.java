import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length,min = 10005;
        int[] cnt = new int[m*n];
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                min = Math.min(min, ints[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((grid[i][j]-min)%x != 0) return -1;
                cnt[i*n+j] = (grid[i][j]-min)/x;
            }
        }
        Arrays.sort(cnt);
        int i = m*n/2, pre = 0, pos = 0;
        for (int j = 0; j < i; j++) {
            pre += cnt[j];
        }
        for (int j = m*n-1; j > i; j--) {
            pos += cnt[j];
        }
        int l = i==0 ? 0 : (i*cnt[i]-pre);
        int r = i==(m*n-1) ? 0 : (pos-(m*n-i-1)*cnt[i]);
        return l+r;
    }
}
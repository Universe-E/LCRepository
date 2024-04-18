class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) cnt[i]++;
                else cnt[j]++;
            }
        }
        int res = -1,mx = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > mx) {
                res = i;
                mx = cnt[i];
            }
        }
        return res;
    }
}
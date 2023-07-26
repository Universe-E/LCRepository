import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int res = 0;
        for (int j = m-1; j >= 0; j--) {
            int mx = 0;
            for (int[] ints : grid) {
                mx = Math.max(mx, ints[j]);
            }
            res += mx;
        }
        return res;
    }
}
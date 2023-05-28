import java.util.HashSet;

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Integer> tl = new HashSet<>(), br = new HashSet<>();
                for (int i1 = i-1,j1 = j-1; i1 >= 0 && j1 >= 0; i1--,j1--) tl.add(grid[i1][j1]);
                for (int i2 = i+1,j2 = j+1; i2 < m && j2 < n; i2++,j2++) br.add(grid[i2][j2]);
                ans[i][j] = Math.abs(tl.size()-br.size());
            }
        }
        return ans;
    }
}
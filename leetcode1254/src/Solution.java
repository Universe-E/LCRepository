import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public static final int[] d = new int[] {1,0,-1,0,1};
    int cnt = 0;
    int[][] grid;
    int n,m;
    HashSet<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        this.n = n;
        this.m = m;
        this.grid = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this.grid[i][j] == 0) {
                    set1.clear();
                    set2.clear();
                    fill(i,j);
                    if (!set1.contains(0) && !set1.contains(n-1) && !set2.contains(0) && !set2.contains(m-1)) cnt++;
                }
            }
        }
        return cnt;
    }

    private void fill(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 0) return;
        set1.add(i);
        set2.add(j);
        grid[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            int x = i+d[k], y = j+d[k+1];
            fill(x,y);
        }
    }
}
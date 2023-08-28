import java.util.HashMap;

class Solution {
    int n,m;
    public int countServers(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) res += ok(i,j,grid) ? 1 : 0;
            }
        }
        return res;
    }

    private boolean ok(int i, int j, int[][] grid) {
        for (int i2 = 0; i2 < n; i2++) {
            if (i2 == i) continue;
            if (grid[i2][j] == 1) return true;
        }
        for (int j2 = 0; j2 < m; j2++) {
            if (j2 == j) continue;
            if (grid[i][j2] == 1) return true;
        }
        return false;
    }
}

class Solution {
    int n,m;
    public int countServers(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        HashMap<Integer,Integer> row = new HashMap<>(),col = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row.merge(i,1,Integer::sum);
                    col.merge(j,1,Integer::sum);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (row.get(i) > 1 || col.get(j) > 1)) res++;
            }
        }
        return res;
    }
}
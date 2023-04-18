import java.util.Arrays;

class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int n = grid.length, len = n*n;
        int[][] route = new int[len][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = i*n+j;
                route[index][0] = i;
                route[index][1] = j;
                route[index][2] = grid[i][j];
            }
        }
        Arrays.sort(route, (o1,o2) -> (o1[2]-o2[2]));
        for (int i = 1; i < len; i++) {
            int a = Math.abs(route[i][0]-route[i-1][0]);
            int b = Math.abs(route[i][1]-route[i-1][1]);
            if (!ok(a,b)) return false;
        }
        return true;
    }

    public boolean ok(int a, int b) {
        return (a==1 && b==2) || (a==2 && b == 1);
    }
}
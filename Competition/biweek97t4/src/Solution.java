import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public static final int[] d = new int[] {1,0,1};
    public boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] v = new boolean[m][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        v[0][0] = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            if (sz == 1) {
                int[] t = q.peek();
                if (!Arrays.equals(t,new int[] {0,0}) && !Arrays.equals(t,new int[] {m-1,n-1})) return true;
            }
            while (sz > 0) {
                int[] t = q.pollFirst();
                sz--;
                for (int i = 0; i < 2; i++) {
                    int x = t[0]+d[i], y = t[1]+d[i+1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || v[x][y]) continue;
                    q.addLast(new int[] {x,y});
                    v[x][y] = true;
                }
            }
        }
        //如果访问不到终点，也返回true
        if (!v[m-1][n-1]) return true;
        return false;
    }
}
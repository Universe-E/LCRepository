import java.util.ArrayDeque;

class Solution {
    public static final int[] d = new int[] {1,0,-1,0,1};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        boolean[][] v = new boolean[n][m];
        ArrayDeque<int[]> ad = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 0) isWater[i][j] = 2005;
                else {
                    isWater[i][j] = 0;
                    v[i][j] = true;
                    ad.addLast(new int[] {i,j,0});
                }
            }
        }
        //多起点bfs
        while (!ad.isEmpty()) {
            int[] cur = ad.pollFirst();
            int cx = cur[0],cy = cur[1],cd = cur[2];
            for (int i = 0; i < 4; i++) {
                int x = cx+d[i], y = cy+d[i+1], depth = cd+1;
                if (x<0 || x>=n || y<0 || y>=m || v[x][y]) continue;
                isWater[x][y] = depth;
                v[x][y] = true;
                ad.addLast(new int[] {x,y,depth});
            }
        }
        return isWater;
    }
}
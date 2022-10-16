import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length,n = heightMap[0].length;
        boolean[][] board = new boolean[m][n];
        //先找边界，按木桶问题，从最矮边界出发向内找
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.add(new int[] {i*n+j,heightMap[i][j]});
                    board[i][j] = true;
                }
            }
        }
        int[] d = new int[] {-1,0,1,0,-1};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //从最矮的边界向内找
            int i = cur[0] / n,j = cur[0] % n;
            for (int k = 0; k < 4; k++) {
                int cx = i + d[k];
                int cy = j + d[k + 1];
                if (cx < 0 || cx >= m || cy < 0 || cy >= n || board[cx][cy]) continue;
                board[cx][cy] = true;
                if (heightMap[cx][cy] < cur[1]) res += cur[1] - heightMap[cx][cy];
                pq.add(new int[] {cx*n+cy,Math.max(heightMap[cx][cy],cur[1])});
            }
        }
        return res;
    }
}
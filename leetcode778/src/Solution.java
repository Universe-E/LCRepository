import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int res = 0;
    private static final int[] d = new int[] {-1,0,1,0,-1};
    //每次都从最小点过去，dj算法
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        //存储最小的grid[i][j]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        pq.add(new int[] {0,0});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            //每次拿出当前高度最小的元素
            int[] cur = pq.poll();
            int x = cur[0],y = cur[1];
            //如果拿到了终点，直接返回
            res = Math.max(res,grid[x][y]);
            if (x == n-1 && y == n-1) return res;
            //将四个方向的添加进去
            for (int i = 0; i < 4; i++) {
                int cx = x + d[i],cy = y + d[i+1];
                if (cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy]) continue;
                pq.add(new int[] {cx,cy});
                visited[cx][cy] = true;
            }
        }
        return res;
    }
}
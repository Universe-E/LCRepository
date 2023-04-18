import java.util.ArrayDeque;

class Solution {
    private int n;
    private static final int[] d = new int[] {-1,0,1,0,-1};
    ArrayDeque<int[]> deque = new ArrayDeque<>();
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        this.n = n;
        boolean visited = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //将第一个岛所有值设为2，并存储所有的坐标
                    dfs(grid,i,j);
                    //dfs之后，立即结束
                    visited = true;
                    break;
                }
            }
            if (visited) break;
        }
        return bfs(grid);
    }
    //默认将第1个岛修改成2，第二个岛不变，并存储所有第一个岛的坐标点
    private void dfs(int[][] grid,int i,int j) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 2;
        deque.add(new int[] {i,j});
        for (int k = 0; k < 4; k++) {
            int cx = i+d[k], cy = j+d[k+1];
            dfs(grid,cx,cy);
        }
    }

    //注意bfs模板
    private int bfs(int[][] grid) {
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] cur = deque.pollFirst();
                int x = cur[0], y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int cx = x+d[j], cy = y+d[j+1];
                    if (cx < 0 || cx >= n || cy < 0 || cy >= n || grid[cx][cy] == 2) continue;
                    if (grid[cx][cy] == 1) return res;
                    if (grid[cx][cy] == 0) {
                        deque.add(new int[] {cx,cy});
                        grid[cx][cy] = 2;
                    }
                }
            }
            res++;
        }
        return res;
    }
}
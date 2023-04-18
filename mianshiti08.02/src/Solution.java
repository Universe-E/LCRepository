import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> temp = new ArrayList<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        boolean[][] visited = new boolean[m][n];
        backTrack(obstacleGrid,visited,m,n,0,0);
        return res;
    }

    private void backTrack(int[][] grid, boolean[][] visited, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 1) return;
        temp.add(new ArrayList<>(Arrays.asList(i,j)));
        visited[i][j] = true;
        if (i == m-1 && j == n-1) {
            res = new ArrayList<>(temp);
            return;
        }
        backTrack(grid,visited,m,n,i+1,j);
        backTrack(grid,visited,m,n,i,j+1);
        temp.remove(temp.size() - 1);
    }
}
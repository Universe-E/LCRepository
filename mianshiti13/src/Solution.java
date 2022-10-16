class Solution {
    int m,n,k;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,visited);
    }

    private int dfs(int i, int j, boolean[][] visited) {
        if (i < 0 || i >= m || j <0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10 > k) || visited[i][j]) return 0;
        visited[i][j] = true;
        return dfs(i + 1,j,visited) + dfs(i,j + 1,visited) + 1;
    }
}
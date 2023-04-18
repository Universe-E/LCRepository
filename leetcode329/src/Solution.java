class Solution {
    int[][] memo;
    public static final int[] d = new int[] {0,1,0,-1,0};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res,dfs(i,j,matrix[i][j],matrix));
            }
        }
        return res;
    }

    private int dfs(int i, int j, int val, int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //已经查找到的结果直接用
        if (memo[i][j] != 0) return memo[i][j];
        //如果该点没有用过，默认设为1
        memo[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int cx = i+d[k], cy = j+d[k+1];
            if (cx < 0 || cx >= m || cy < 0 || cy >= n || matrix[cx][cy] <= val) continue;
            memo[i][j] = Math.max(memo[i][j],dfs(cx,cy,matrix[cx][cy],matrix)+1);
        }
        return memo[i][j];
    }
}
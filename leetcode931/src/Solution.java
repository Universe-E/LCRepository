class Solution {
    int n;
    private static final int inf = 0x3f3f3f3f;
    private static final int[] d = new int[] {-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = matrix[i][j];
                matrix[i][j] = inf;
                for (int k = 0; k < 3; k++) {
                    int cj = j+d[k];
                    if (inArea(i-1,cj)) matrix[i][j] = Math.min(matrix[i][j],cur+matrix[i-1][cj]);
                }
            }
        }
        int res = inf;
        for (int i = 0; i < n; i++) {
            res = Math.min(res,matrix[n-1][i]);
        }
        return res;
    }
}
class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] rowSum = new int[n], colSum = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }
        int[] rowCur = new int[n], colCur = new int[m];
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    //左边有rowCur[i]个元素，右边有rowSum[i]-rowCur[i]-1个元素
                    //上面有colCur[j]个元素，下面有colSum[j]-colCur[j]-1个元素
                    int left = rowCur[i], right = rowSum[i]-rowCur[i]-1,
                            up = colCur[j], down = colSum[j]-colCur[j]-1;
                    res += (long)left*up + (long)left*down + (long)right*up + (long)right*down;
                    rowCur[i]++;
                    colCur[j]++;
                }
            }
        }
        return res;
    }
}
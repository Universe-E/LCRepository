class Solution {
    static int N = 55, INF = Integer.MIN_VALUE;
    static int[][][] f = new int[2 * N][N][N];
    public int cherryPickup(int[][] g) {
        int n = g.length;
        //f[k][i1][i2]表示当前走了 k 步（横纵坐标之和），且第 1 个点当前在第 i1 行，
        //第 2 个点在第 i2 行时的最大得分，最终答案为 f[2n][n][n]
        for (int k = 0; k <= 2 * n; k++) {
            for (int i1 = 0; i1 <= n; i1++) {
                for (int i2 = 0; i2 <= n; i2++) {
                    f[k][i1][i2] = INF;
                }
            }
        }
        f[2][1][1] = g[0][0];
        for (int k = 3; k <= 2 * n; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) continue;
                    int A = g[i1 - 1][j1 - 1], B = g[i2 - 1][j2 - 1];
                    if (A == -1 || B == -1) continue;
                    int a = f[k - 1][i1 - 1][i2], b = f[k - 1][i1 - 1][i2 - 1], c = f[k - 1][i1][i2 - 1], d = f[k - 1][i1][i2];
                    int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;
                    if (i1 != i2) t += B;
                    f[k][i1][i2] = t;
                }
            }
        }
        return Math.max(f[2 * n][n][n], 0);
    }
}
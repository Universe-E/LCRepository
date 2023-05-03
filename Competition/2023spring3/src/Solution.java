class Solution {
    public int fieldOfGreatestBlessing(int[][] forceField) {
        int res = 0, n = forceField.length;
        //lr存储横坐标，du存储纵坐标
        long[] lr = new long[2*n],du = new long[2*n];
        for (int i = 0; i < n; i++) {
            lr[i] = forceField[i][0] * 2L - forceField[i][2];
            lr[n+i] = forceField[i][0] * 2L + forceField[i][2];
            du[i] = forceField[i][1] * 2L - forceField[i][2];
            du[n+i] = forceField[i][1] * 2L + forceField[i][2];
        }
        for (int i = 0; i < 2 * n; i++) {
            long x = lr[i];
            for (int j = 0; j < 2 * n; j++) {
                long y = du[j];
                int cnt = 0;
                for (int[] f : forceField) {
                    long l = f[0] * 2L - f[2],
                            r = f[0] * 2L + f[2],
                            d = f[1] * 2L - f[2],
                            u = f[1] * 2L + f[2];
                    if (x >= l && x <= r && y >= d && y <= u) cnt++;
                }
                res = Math.max(res,cnt);
            }
        }
        return res;
    }
}
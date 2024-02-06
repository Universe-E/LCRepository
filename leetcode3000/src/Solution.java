class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0,mx = 0;
        for (int[] d : dimensions) {
            int cur = d[0] * d[0] + d[1] * d[1];
            if (cur >= mx) {
                if (cur > mx) res = d[0] * d[1];
                else res = Math.max(res,d[0]*d[1]);
                mx = cur;
            }
        }
        return res;
    }
}
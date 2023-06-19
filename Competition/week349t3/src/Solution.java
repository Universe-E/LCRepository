class Solution {
    //遇到影响全局的操作，一般会想到枚举操作次数。
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long[][] f = new long[n][n];
        //f[i][j]表示进行j次操作后，nums[i]的最小值，初始时都是nums[i]
        for (int i = 0; i < n; i++) {
            f[i][0] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //和前一项相比取最小值
                f[i][j] = Math.min(f[i][j-1],nums[(i+j)%n]);
            }
        }
        //枚举操作次数t
        long res = Long.MAX_VALUE;
        for (int t = 0; t < n; t++) {
            long cur = 0;
            for (int i = 0; i < n; i++) {
                cur += f[i][t];
            }
            res = Math.min(res,cur+(long) t*x);
        }
        return res;
    }
}
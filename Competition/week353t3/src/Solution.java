class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length,res = 1;
        int[][] dp = new int[2][2];//dp[i%2][j]表示第i位选择j(1或2)时的最大递增长度
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            //如果可以递增，则选，否则不选
            //空间压缩
            dp[i%2][0] = Math.max(nums1[i]>=nums1[i-1]?(dp[(i-1)%2][0]+1):1,nums1[i]>=nums2[i-1]?(dp[(i-1)%2][1]+1):1);
            dp[i%2][1] = Math.max(nums2[i]>=nums1[i-1]?(dp[(i-1)%2][0]+1):1,nums2[i]>=nums2[i-1]?(dp[(i-1)%2][1]+1):1);
            res = Math.max(res,Math.max(dp[i%2][0],dp[i%2][1]));
        }
        return res;
    }
}
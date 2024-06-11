class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int res1 = dp(nums,2,n-1,nums[0]+nums[1]) + 1;//删除前2个数
        int res2 = dp(nums,0,n-3,nums[n-2]+nums[n-1]) + 1;//删除后2个数
        int res3 = dp(nums,1,n-2,nums[0]+nums[n-1]) + 1;//删除首尾
        return Math.max(res1,Math.max(res2,res3));
    }

    private int dp(int[] nums, int l, int r, int t) {
        int n = nums.length;
        int[][] f = new int[n+1][n+1];
        //避免j出现-1，需要j右移1位
        for (int i = r-1; i >= l; i--) {
            for (int j = i+1; j <= r; j++) {
                //删除前2个数
                if (nums[i]+nums[i+1] == t) f[i][j+1] = Math.max(f[i][j+1],f[i+2][j+1]+1);
                //删除后2个数
                if (nums[j-1]+nums[j] == t) f[i][j+1] = Math.max(f[i][j+1],f[i][j-1]+1);
                //删除首尾
                if (nums[i]+nums[j] == t) f[i][j+1] = Math.max(f[i][j+1],f[i+1][j]+1);
            }
        }
        return f[l][r+1];
    }
}
class Solution {
    public int maxCoins(int[] nums) {
        //预处理arr，在首尾添加1
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[nums.length + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        //不断从开区间(i,j)中找到k并戳破
        int n = arr.length;
        //dp[i][j]表示将区间[i][j]全部戳破拿到的最大得分
        int[][] dp = new int[n][n];
        //枚举长度，至少戳3个（包含了左右边界），至多全部戳完
        for (int len = 3; len <= n; len++) {
            //左边界的取值范围，在(i,i+len-1)区间内找
            for (int i = 0; i < n - len + 1; i++) {
                int res = 0;
                for (int j = i + 1; j < i + len - 1; j++) {
                    int left = dp[i][j];
                    int right = dp[j][i+len-1];
                    //逐个戳破比较，找最大值
                    res = Math.max(res,left + arr[i]*arr[j]*arr[i+len-1] + right);
                }
                dp[i][i+len-1] = res;
            }
        }
        return dp[0][n-1];
    }
}
class Solution {
    //只要最优解大于等于总和的一半即获胜
    public boolean PredictTheWinner(int[] nums) {
        return optimal(nums,0,nums.length - 1) * 2 >= sum(nums, 0, nums.length - 1);
    }

    private int sum(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += nums[i];
        }
        return sum;
    }


    //optimal代表[l,r]当中的最优解
    private int optimal(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        //每次都要留给对手最差的”最优解“
        return sum(nums, l ,r) - Math.min(optimal(nums, l + 1, r), optimal(nums, l, r - 1));
    }
}

class Solution {
    //只要最优解大于等于总和的一半即获胜
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];//dp[i][j]表示在[i,j]范围内两玩家分数差的最大值
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        //i must be less than j
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                //select
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}
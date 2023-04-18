//贪心算法：如果当前和小于0，则丢弃之前的数列
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            if (sum >= 0) sum += num;
            else sum = num;
            //每次更新较大的res
            res = Math.max(res, sum);
        }
        return res;
    }
}

//每次将当前的nums[i]和前一个元素相比，如果前一个元素>0则加到当前元素上，最大值即为最大子数组和
class Solution2 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}

class Solution3 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) dp[i] = nums[i] + dp[i-1];
            else dp[i] = nums[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
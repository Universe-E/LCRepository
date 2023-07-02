class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length,l = 0, r = -1;//[l,r]为滑动窗口
        int sum = 0, res = n+1;
        while (l < n) {
            if (r != n-1 && sum < target) sum += nums[++r];
            else sum -= nums[l++];
            if (sum >= target) res = Math.min(res,r-l+1);
        }
        return res==n+1 ? 0 : res;
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length,res = n+1;
        for (int r = 0,l = 0,sum = 0; r < n; r++) {
            sum += nums[r];
            //尝试缩进l看是否仍符合条件
            while (l <= r && sum-nums[l] >= target) {
                sum -= nums[l++];
                res = Math.min(res,r-l+1);
            }
        }
        return res == n+1 ? 0 : res;
    }
}
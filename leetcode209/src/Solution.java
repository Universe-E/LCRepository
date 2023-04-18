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
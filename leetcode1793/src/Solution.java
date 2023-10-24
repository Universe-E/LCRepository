class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length,res = 0, l = k,r = k;
        while (true) {
            //以nums[k]为最小值扩展到边界
            while (r < n && nums[r] >= nums[k]) r++;
            while (l >= 0 && nums[l] >= nums[k]) l--;
            //更新res
            res = Math.max(res,(r-l-1)*nums[k]);
            if (l < 0 && r >= n) break;
            //nums[l]和nums[r]一定都小于nums[k]
            //接下来，nums[k]更新为nums[l]和nums[r]中最大的，然后以这个次大值继续找
            nums[k] = Math.max(l < 0 ? 0 : nums[l],r >= n ? 0 : nums[r]);
        }
        return res;
    }
}
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length,res1 = 0,res2 = 0;
        for (int i = 0; i < n; i++) {
            int l = i==0 ? 0 : nums[i]>=nums[i-1] ? (nums[i]+1-nums[i-1]) : 0;
            int r = i==(n-1) ? 0 : nums[i]>=nums[i+1] ? (nums[i]+1-nums[i+1]) : 0;
            if (i%2==0) res1 += Math.max(l,r);
            else res2 += Math.max(l, r);
        }
        return Math.min(res1,res2);
    }
}
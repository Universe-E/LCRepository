class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length, res = 0;
        long pre = 0;
        for(int i = 0; i < n; i++) {
            pre += nums[i];
            int avg = (int) (pre/(i+1) + (pre%(i+1) == 0 ? 0 : 1));
            res = Math.max(res,Math.min(nums[i],avg));
        }
        return res;
    }
}
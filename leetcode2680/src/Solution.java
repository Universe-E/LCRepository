class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n+1],suf = new int[n+1];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] | nums[i];
            suf[n-i-1] = suf[n-i] | nums[n-i-1];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,pre[i] | ((long) nums[i] << k) | suf[i+1]);
        }
        return res;
    }
}
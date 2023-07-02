class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n+1];
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] == 1) suf[i] = suf[i+1]+1;
            else suf[i] = 0;
        }
        int res = 0;
        for (int i = 0,pre = 0; i < n; i++) {
            res = Math.max(res,pre+suf[i+1]);
            if (nums[i] == 1) pre++;
            else pre = 0;
        }
        return res;
    }
}
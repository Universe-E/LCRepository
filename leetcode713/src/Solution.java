class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (k <= 1) return 0;
        int l = 0, r = 0,res = 0,cur = 1;
        while (r < n) {
            cur *= nums[r];
            while (l < n && cur >= k) {
                cur /= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}
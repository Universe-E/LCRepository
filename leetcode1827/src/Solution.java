class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i-1]) {
                res += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return res;
    }
}
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, sum = nums[0];
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + nums[i];
            sum += nums[i];
        }
        if (sum - nums[0] == 0) return 0;
        for (int i = 1; i < n; i++) {
            if (pre[i-1] == sum-pre[i]) return i;
        }
        return -1;
    }
}
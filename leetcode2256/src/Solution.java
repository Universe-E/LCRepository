class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        long left = 0, right = sum;
        int avg = Integer.MAX_VALUE, ptr = -1;
        for (int i = 0; i < n; i++) {
            left += nums[i];
            right -= nums[i];
            int l = (int) (left / (i+1));
            int r;
            if (i != n-1) r = (int) (right / (n-i-1));
            else r = 0;
            int cur = Math.abs(l-r);
            if (cur < avg) {
                avg = cur;
                ptr = i;
            }
        }
        return ptr;
    }
}
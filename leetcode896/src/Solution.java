class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        //declare variable "pos" to control the monotonicity
        int pos = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i-1] > 0) {
                if (pos == 0) pos = 1;
                if (pos == -1) return false;
            }
            if (nums[i] - nums[i-1] < 0) {
                if (pos == 0) pos = -1;
                if (pos == 1) return false;
            }
        }
        return true;
    }
}
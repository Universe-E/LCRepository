class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n+1];
        diff[0] = nums[0];
        diff[n] = -nums[n-1];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i]-nums[i-1];
        }
        for (int i = 0; i < n+1-k; i++) {
            if (diff[i] < 0) return false;
            if (diff[i] > 0) {//只能减少不能增加
                diff[i+k] += diff[i];
                diff[i] = 0;
            }
        }
        for (int i = n+1-k; i < n + 1; i++) {
            if (diff[i] != 0) return false;
        }
        return true;
    }
}
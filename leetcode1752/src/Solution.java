class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int split = 0;
        for(int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                split = i;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[(i+split)%n] < nums[(i+split-1)%n]) return false;
        }
        return true;
    }
}
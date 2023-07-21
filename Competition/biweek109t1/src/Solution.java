import java.util.Arrays;

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != n-1) {
                if (nums[i] != i+1) return false;
            }
            else {
                if (nums[i] != i) return false;
            }
        }
        return true;
    }
}
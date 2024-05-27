import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] >= n - i) {
                if (i == 0) return n;
                else if (nums[i - 1] >= n - i) return -1;
                else return n - i;
            }
        }
        return -1;
    }
}

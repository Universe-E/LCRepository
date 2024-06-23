import java.util.Arrays;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int r = 0, l = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > 2 * k) l++;
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
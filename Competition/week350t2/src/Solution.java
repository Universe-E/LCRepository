import java.util.Arrays;

class Solution {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0x3f3f3f3f;
        for (int i = 1; i < n; i++) {
            res = Math.min(res,nums[i]-nums[i-1]);
        }
        return res;
    }
}
import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length,res = 0;
        Arrays.sort(nums);
        for (int i = 0,j = n-1; i < j; i++,j--) {
            res = Math.max(res,nums[i]+nums[j]);
        }
        return res;
    }
}
import java.util.Arrays;

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.sort(nums);
        int res = nums[n-1] - nums[0];
        //本质上是找一个i，左侧都加k，右侧都减k
        for (int i = 1; i < n; i++) {
            int l = Math.min(nums[0]+k,nums[i]-k);
            int r = Math.max(nums[n-1]-k,nums[i-1]+k);
            res = Math.min(res,r-l);
        }
        return res;
    }
}
import java.util.Arrays;

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        //不断求平均值，找sum[i]/(i+1)找到最大值，因为左边的大数传递不到右边来
        int res = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            long avg = sum / (i+1) + ((sum % (i+1)) == 0 ? 0 : 1);
            res = Math.max(res,(int) avg);
        }
        return res;
    }
}
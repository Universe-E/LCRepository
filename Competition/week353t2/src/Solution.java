import java.util.Arrays;

class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[n];//dp[i]表示跳到i处所需的最大次数
        Arrays.fill(f,-1);
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                //j合法，即之前访问过
                if (Math.abs(nums[i]-nums[j]) <= target && f[j] != -1) f[i] = Math.max(f[i],f[j]+1);
            }
        }
        return f[n-1];
    }
}
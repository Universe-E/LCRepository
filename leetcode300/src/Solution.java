import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //dp[i]只能增加不会减小，因此不能用较小值替代掉较大值
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }
}

class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        int len = 0;
        for (int num : nums) {
            //初始时，r对应d数组右边第一个0
            //每次找比nums[i]大的最小值（相等也可以）；如果有则让nums[i]替代该值，否则让nums[i]添加到d数组最后
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (d[mid] < num) l = mid + 1;
                else r = mid;
            }
            d[l] = num;
            //如果最后右边界没有更新，说明l一直寻到了r，d数组被更新，因此len自增
            if (r == len) len++;
        }
        return len;
    }
}
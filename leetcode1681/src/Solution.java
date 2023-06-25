import java.util.Arrays;

class Solution {
    public static final int inf = 0x3f3f3f3f;
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        //预处理所有符合条件的子集，计算其不兼容性
        int[] values = new int[1<<n];
        Arrays.fill(values,-1);
        for (int sub = 0; sub < (1 << n); sub++) {
            if (Integer.bitCount(sub) == (n/k)) values[sub] = calculate(nums,sub);
        }
        int[] dp = new int[1<<n];//dp[i]表示选择集合i时的最小不兼容和
        //dp[i] = min(dp[i^sub]+values[sub])
        Arrays.fill(dp,inf);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            //判断i是否有(n/k)倍数的子集
            if (Integer.bitCount(i) % (n/k) != 0) continue;
            //枚举i的子集
            for (int j = i; j != 0; j = ((j-1)&i)) {
                if (values[j] != -1 && dp[i^j] != inf) dp[i] = Math.min(dp[i],dp[i^j]+values[j]);
            }
        }
        return dp[(1<<n)-1] == inf ? -1 : dp[(1<<n)-1];
    }

    //计算每个子集的不兼容性
    private int calculate(int[] nums,int sub) {
        int n = nums.length;
        int[] temp = new int[n+1];
        int mn = 17,mx = -1;
        for (int i = 0; i < n; i++) {
            if ((sub & (1<<i)) != 0) {
                //不能包含重复元素
                if (temp[nums[i]] != 0) return -1;
                temp[nums[i]]++;
                mn = Math.min(mn,nums[i]);
                mx = Math.max(mx,nums[i]);
            }
        }
        return mx-mn;
    }
}
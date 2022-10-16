import java.util.LinkedHashMap;

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];//表示让前i个元素严格递增的操作次数,dp[i][0]表示不交换nums1[i]和nums2[i],dp[i][1]表示交换
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            //方便后续赋值
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                dp[i][0] = dp[i - 1][0];//此时可以不交换
                dp[i][1] = dp[i - 1][1] + 1;//也可以交换
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {//此时可以只交换其中一对数字
                dp[i][0] = Math.min(dp[i][0],dp[i - 1][1]);//交换i-1的情况
                dp[i][1] = Math.min(dp[i][1],dp[i - 1][0] + 1);//交换i的情况
            }
        }
        LinkedHashMap<Integer,Integer> lmap = new LinkedHashMap<>();
        lmap.

        return Math.min(dp[n - 1][0],dp[n-1][1]);
    }
}
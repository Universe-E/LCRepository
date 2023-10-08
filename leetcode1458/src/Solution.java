import java.util.Arrays;

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        //dp[i+1][j+1]表示分别在nums1[0,i]和nums2[0,j]的范围内找到的子序列乘积的最大值
        int[][] dp = new int[n1+1][n2+1];
        //索引0的位置无意义，值为负无穷
        Arrays.fill(dp[0], -0x3f3f3f3f);
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = -0x3f3f3f3f;
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int mul = nums1[i]*nums2[j];
                //对于每个dp[i+1][j+1]，选择是否累加当前乘积
                //如果不选，则从上一位(dp[i][j+1])或左一位(dp[i+1][j])转移最大值
                //如果选，则再分2中情况：
                //1.不利用之前的状态，从零开始计算，此时值为乘积
                //2.利用之前的状态，此时值为乘积+dp[i][j]
                dp[i+1][j+1] = Math.max(Math.max(dp[i+1][j],dp[i][j+1]),mul+Math.max(dp[i][j],0));
            }
        }
        return dp[n1][n2];
    }
}
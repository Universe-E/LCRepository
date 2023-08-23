import java.util.Arrays;

class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[] v1 = new int[n-1],v2 = new int[n-1];
        //环状序列相较于普通序列，相当于添加了一个限制：普通序列中的第一个和最后一个数不能同时选。
        //这样一来，我们只需要对普通序列进行两遍动态即可得到答案，
        //第一遍动态规划中我们删去普通序列中的第一个数，表示我们不会选第一个数；
        //第二遍动态规划中我们删去普通序列中的最后一个数，表示我们不会选最后一个数。
        //将这两遍动态规划得到的结果去较大值，即为在环状序列上的答案。
        System.arraycopy(slices,1,v1,0,n-1);
        System.arraycopy(slices,0,v2,0,n-1);
        return Math.max(cal(v1),cal(v2));
    }

    //dp[i][j]表示在前i个数中选择了j个不相邻的数的最大和
    private int cal(int[] slices) {
        int m = slices.length,n = (m+1)/3;
        int[][] dp = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],1,n+1,Integer.MIN_VALUE/2);
        }
        dp[0][1] = slices[0];
        dp[1][1] = Math.max(slices[0],slices[1]);
        for (int i = 2; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                //选或不选，如果不选i，则在i-1里面选j个，如果选了i，则在i-2里面选j-1个
                dp[i][j] = Math.max(dp[i-1][j],dp[i-2][j-1]+slices[i]);
            }
        }
        return dp[m-1][n];
    }

}
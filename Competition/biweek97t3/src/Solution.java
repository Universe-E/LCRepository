class Solution {
    public int maximizeWin(int[] pp, int k) {
        int n = pp.length, l = 0,res = 1;
        //dp[i]表示第一根线段右端点截止i处时能找到的最大值
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            //滑动窗口，找到第一个满足范围的左边界
            while (pp[i]-pp[l] > k) l++;
            int rCnt = i-l+1;//记录当前第二根线段的值
            //在[0,l-1]区间找第一根线段的最大值，即dp[l-1]
            res = Math.max(res,(l==0?0:dp[l-1])+rCnt);
            //更新一下以i为右端点的dp[i]最大值，后面要用
            dp[i] = Math.max(dp[i-1],rCnt);
        }
        return res;
    }
}
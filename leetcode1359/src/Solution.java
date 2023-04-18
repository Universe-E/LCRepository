class Solution {
    public static final int M = (int)1e9+7;
    public int countOrders(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        //考察p[i]和d[i]，可能相邻也可能不相邻
        //如果相邻，则直接插入到dp[i-1]的任何一位（有2i-1中插入法）
        //如果不相邻，则在2i-1个位置中，选择2个插入，此时有(2i-1)(2i-2)/2 = (2i-1)(i-1)种插入法
        //综上，共有(2i-1)(i-1)+(2i-1)=i*(2i-1)种插入法
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1]*(2*i*i-i))%M;
        }
        return (int) dp[n];
    }
}
class Solution {
    public static final int M = (int)1e9+7;
    public int countOrders(int n) {
        if (n==1) return 1;
        return (int) ((long)countOrders(n-1)*n*(2*n-1)%1000000007);
    }
}
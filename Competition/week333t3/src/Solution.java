import java.util.Arrays;

class Solution {
    public static final int M = (int)1e9 + 7;
    public static final int[] Primes = new int[] {2,3,5,7,11,13,17,19,23,29};
    //max表示最大值，cnt表示Primes数组中的子集个数
    public static final int Max = 30,Len = Primes.length,Cnt = 1<<Len;
    //NSQ[i]表示i对应的质数集合
    public static final int[] NSQ = new int[Max+1];
    static {
        for (int i = 2; i <= 30; i++) {
            for (int j = 0; j < Len; j++) {
                //如果能整除
                if (i % Primes[j] == 0) {
                    //如果能整除平方，则不符合条件
                    if (i % (Primes[j]*Primes[j]) == 0) {
                        NSQ[i] = -1;
                        break;
                    }
                    //记录这是第j个质数，用二进制表示在NSQ[i]中
                    NSQ[i] |= 1<<j;
                }
            }
        }
    }
    public int squareFreeSubsets(int[] nums) {
        int[] dp = new int[Cnt];//dp[i]表示组合成i这种集合的方案数
        dp[0] = 1;//第一位留给空集，空集的方案数默认为1
        //随后是背包问题
        for (int num : nums) {
            int mask = NSQ[num];//获取num的质数集合
            //如果当前num能够被多个质数的集合表示，则进入背包问题
            if (mask != -1) {
                //遍历所有集合直到当前的质数集合，更小的集合一定不符合条件
                for (int i = Cnt-1; i>= mask; i--) {
                    //如果i是mask的子集
                    if ((i|mask) == i) {
                        dp[i] = (dp[i] + (dp[i^mask]))%M;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int res = 0;
        for (int i = 0; i < Cnt; i++) {
            res = (res + dp[i])%M;
        }
        return (res-1+M)%M;
    }
}
import java.util.Arrays;

class Solution {
    //例如： coins = [1,2,5] amount = 6;
    //   dp[i-5]              dp[i-2] dp[i-1] dp[i]
    //0     1      2      3      4      5      6
    //因此dp[i] = Math.min(dp[i],dp[i - coin] + 1)，即逐个遍历i - coin面额的兑换数量并加一即是当前面额的兑换数量
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        //如果amount没有被更新，说明amount不能被兑换，此时返回-1，否则说明能被兑换，直接返回即可
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }
}

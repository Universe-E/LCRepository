import java.util.List;

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        //分组背包，dp[i][j]表示前面i个栈取了j个，其中j <= k
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            //记录前i个栈取的数量为j,j∈[0,k]
            for (int j = 0; j <= k; j++) {
                int sum = 0;//记录前面i个栈的前缀和
                //在总共取j个的前提下，考察第i个栈取的数量l,满足l∈[0,min(piles[i-1].size(),j)]
                for (int l = 0; l <= j && l <= piles.get(i-1).size(); l++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-l]+sum);
                    if (l < piles.get(i-1).size()) sum += piles.get(i-1).get(l);
                }
            }
        }
        return dp[n][k];
    }
}

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        //dp[i]表示总共取i个物品
        int[] dp = new int[k+1];
        for (List<Integer> pile : piles) {
            //预处理前缀和
            int pn = pile.size();
            for (int i = 1; i < pn; i++) {
                pile.set(i,pile.get(i)+pile.get(i-1));
            }
            //考察取k个的可能性，倒序遍历的原因是第一维被压缩了
            //转移来源是dp[i-1][j-w]，压缩后为dp[j-w]。
            //如果正向遍历的话，压缩后的 f[j-w] 已经被计算过了，变成 f[i][j-w] 了，这和期望的转移来源 f[i-1][j-w] 相违背。
            for (int i = k; i > 0; i--) {
                for (int j = 0; j < Math.min(pn, i); j++) {
                    dp[i] = Math.max(dp[i],dp[i-j-1]+pile.get(j));
                }
            }
        }
        return dp[k];
    }
}
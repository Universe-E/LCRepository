import java.util.Arrays;

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];//dp[i]为[0,i]高度和的最小值
        Arrays.fill(dp, 1000001);
        for (int i = 0; i < n; i++) {
            int w = 0, h = 0;
            //对于dp[i]，nums[i]已经确定是最后一个元素，如果顺序枚举，没法快速知道 nums[j...i] 的厚度之和，也没法快速得到这部分书的最大高度
            //主要思路是，放在同一行的一定是相邻位置
            for (int j = i; j >= 0; j--) {
                w += books[j][0];
                h = Math.max(h,books[j][1]);
                if (w > shelfWidth) break;
                //每一组可以放在同一行的[j,i]，都对应一个h和dp[j-1]，这样就实现了转移
                dp[i] = Math.min(dp[i],(j == 0 ? 0 : dp[j-1]) + h);
            }
        }
        return dp[n-1];
    }
}
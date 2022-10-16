import java.util.Arrays;
class Solution {
    public long minimumMoney(int[][] transactions) {
        //按照净花费从高到底排序
        Arrays.sort(transactions, (o1, o2) -> (o2[0] - o2[1]) - (o1[0] - o1[1]));
        long res = 0;
        int n = transactions.length;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur <= transactions[i][0]) {
                res += transactions[i][0] - cur;
                cur = res - transactions[i][0] + transactions[i][1];
            }
        }
        return res + 1;
    }
}
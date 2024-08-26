import java.util.Arrays;

class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length, sum = 0;
        Arrays.sort(cards);
        for (int i = n-cnt; i < n; i++) {
            sum += cards[i];
        }
        if (sum % 2 == 0) return sum;
        int sum1 = sum, sum2 = sum, flag1 = 1, flag2 = 1;
        //1. 从[n-cnt,n-1]去掉最小奇数，从[0,n-cnt-1]选最大偶数
        //2. 从[n-cnt,n-1]去掉最小偶数，从[0,n-cnt-1]选最大奇数
        //取最大值
        for (int i = n-cnt; i < n; i++) {
            if (cards[i] % 2 != 0 && flag1 == 1) {
                sum1 -= cards[i];
                flag1 = 0;
            }
            if (cards[i] % 2 == 0 && flag2 == 1) {
                sum2 -= cards[i];
                flag2 = 0;
            }
        }
        int flag3 = 1, flag4 = 1;
        for (int i = n-cnt-1; i >= 0; i--) {
            if (cards[i] % 2 == 0 && flag3 == 1) {
                sum1 += cards[i];
                flag3 = 0;
            }
            if (cards[i] % 2 != 0 && flag4 == 1) {
                sum2 += cards[i];
                flag4 = 0;
            }
        }
        //替换不成功
        if (flag1 == 1 || flag3 == 1) sum1 = 0;
        if (flag2 == 1 || flag4 == 1) sum2 = 0;
        return Math.max(sum1,sum2);

    }
}
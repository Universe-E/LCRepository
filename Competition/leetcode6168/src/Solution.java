import java.math.BigInteger;

class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int netForward = endPos - startPos;//声明净向右移动距离
        if ((k + netForward) % 2 != 0) return 0;
        int right = (k + netForward) / 2;
        int left = k - right;
        //返回值应为kCright
        int r = Math.min(left,right);
        long sum1 = 1,sum2 = 1;
        int flow1 = 0,flow2 = 0;

        for (int i = k; i >= k - r + 1; i--) {
            sum1 = sum1 * i;
            if (sum1 > 1000000009) {
                flow1 += sum1 / 1000000009;
                sum1 %= 1000000009;
            }
        }
        for (int i = r; i >= 1; i--) {
            sum2 = sum2 * i;
            if (sum2 > 1000000009) {
                flow2 += sum2 / 1000000009;
                sum2 %= 1000000009;
            }
        }
        for (int i = 0; i < flow1 - flow2; i++) {

        }

    }
}

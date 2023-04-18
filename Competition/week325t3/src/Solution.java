import java.util.Arrays;

class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int min = price[0], max = price[n-1];
        if (k==2) return max - min;
        //最大的可能就是价格均匀上升，此时最大绝对值是平均差，例如2,10,18,26, k = 4
        long l = 0, r = (max-min) / (k-1);
        while (l < r) {
            //从最小值往最大值按照mid的步长找
            long mid = (l+r+1) / 2;
            int cnt = 1, pre = price[0];
            for (int i = 1; i < n; i++) {
                if (price[i] >= pre + mid) {
                    cnt++;
                    pre = price[i];
                }
            }
            //如果符合的次数大于k，则说明步长还能继续往上取
            if (cnt >= k) l = mid;
            //否则要缩短步长
            else r = mid - 1;
        }
        return (int) l;
    }
}
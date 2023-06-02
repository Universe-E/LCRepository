import java.util.Arrays;

class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        //声明最小和最大甜蜜度
        int l = 0,r = price[n-1]-price[0];
        while (l < r) {
            int m = (l+r+1)/2;
            //如果当前甜蜜度满足条件，说明m还可以增大，更新下界
            if (check(price,m,k)) l = m;
            //如果不满足条件，说明m太大，更新上界
            else r = m-1;
        }
        return l;
    }

    private boolean check(int[] price,int t,int k) {
        int cnt = 0,pre = -0x3f3f3f3f;
        for (int p : price) {
            if (p - pre >= t) {
                pre = p;
                cnt++;
            }
        }
        return cnt >= k;
    }
}
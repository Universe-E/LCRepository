import java.util.Random;

class Solution {
    int[] pre;
    int sum;
    Random r;
    public Solution(int[] w) {
        r = new Random();
        int n = w.length;
        pre = new int[n];
        pre[0] = w[0];
        for (int i = 1; i < n; i++) {
            pre[i] = w[i] + pre[i-1];
        }
        sum = pre[n-1];
    }

    public int pickIndex() {
        int rnd = 1 + r.nextInt(sum);
        //在pre中找大于等于rnd的最小坐标
        int l = 0, r = pre.length-1;
        while (l < r) {
            int m = (l+r)/2;
            if (pre[m] < rnd) l = m+1;
            else r = m;
        }
        return l;
    }
}
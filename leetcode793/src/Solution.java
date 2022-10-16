class Solution {
    public int preimageSizeFZF(int k) {
        long l = 0,r = (long) Integer.MAX_VALUE << 1;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long target = getFive(mid);
            if (target == k) return 5;
            else if (target > k) r = mid - 1;
            else l = mid + 1;
            System.out.println(l + "," + r);
        }
        return 0;
    }

    //首先找到当前值有多少个5的因子
    private long getFive(long n) {
        long ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}

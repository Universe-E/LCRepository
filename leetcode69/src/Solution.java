class Solution {
    public int mySqrt(int x) {
        int l = 0,r = x;
        while (l < r) {
            int mid = Math.min(46341,(l + r + 1) / 2);
            if (mid == 46341 || mid * mid > x) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l = 1,r = 0;
        for (int battery : batteries) {
            r += battery;
        }
        r /= n;
        while (l < r) {
            long m = (l+r+1)/2;
            long sum = 0;
            for (int battery : batteries) {
                sum += Math.min(battery,m);
            }
            if (sum >= m*n) l = m;
            else r = m-1;
        }
        return l;
    }
}
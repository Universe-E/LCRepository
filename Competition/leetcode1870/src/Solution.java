class Solution {
    int n;
    public int minSpeedOnTime(int[] dist, double hour) {
        n = dist.length;
        int l = 1,r = (int) 1e7;
        if (n-1 >= hour) return -1;
        while (l < r) {
            int m = (l+r)/2;
            if (ok(dist,m,hour)) r = m;
            else l = m + 1;
        }
        return l;
    }

    private boolean ok(int[] dist, int m, double hour) {
        double res = 0;
        for (int i = 0; i < n-1; i++) {
            res += Math.ceil((double) dist[i]/m);
        }
        res += (double) dist[n-1]/m;
        return res <= hour;
    }
}